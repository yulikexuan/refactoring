package refactoring.catalog.api.domain.service;


import com.google.common.collect.Lists;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import static org.mockito.BDDMockito.then;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test class MiscreantSearchService - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class MiscreantSearchServiceTest {

    @Mock
    private AlertService alertService;

    private MiscreantSearchService miscreantSearchService;

    private String[] currentMiscreantArray;

    @BeforeEach
    void setUp() {
        this.currentMiscreantArray = new String[] {
                RandomStringUtils.randomAlphabetic(7),
                RandomStringUtils.randomAlphabetic(7),
        };
        this.miscreantSearchService = MiscreantSearchService.of(
                Lists.newArrayList(currentMiscreantArray),
                this.alertService);
    }

    @Test
    void able_To_Find_Out_Miscreant_From_People_And_Alert() {

        // Given
        List<String> people_1 = List.of(
                RandomStringUtils.randomAlphabetic(7),
                RandomStringUtils.randomAlphabetic(7),
                RandomStringUtils.randomAlphabetic(7),
                currentMiscreantArray[0],
                RandomStringUtils.randomAlphabetic(7),
                RandomStringUtils.randomAlphabetic(7),
                currentMiscreantArray[1]);

        List<String> people_2 = List.of(
                RandomStringUtils.randomAlphabetic(7),
                currentMiscreantArray[1],
                RandomStringUtils.randomAlphabetic(7),
                RandomStringUtils.randomAlphabetic(7),
                RandomStringUtils.randomAlphabetic(7),
                RandomStringUtils.randomAlphabetic(7),
                currentMiscreantArray[0]);

        List<String> people_3 = List.of(
                RandomStringUtils.randomAlphabetic(7),
                RandomStringUtils.randomAlphabetic(7),
                RandomStringUtils.randomAlphabetic(7));

        // When
        Optional<String> miscreantOpt_1 =
                this.miscreantSearchService.findMiscreantByName(people_1);
        this.miscreantSearchService.alertForFoundMiscreant(people_1);

        Optional<String> miscreantOpt_2 =
                this.miscreantSearchService.findMiscreantByName(people_2);
        this.miscreantSearchService.alertForFoundMiscreant(people_2);

        Optional<String> miscreantOpt_3 =
                this.miscreantSearchService.findMiscreantByName(people_3);
        this.miscreantSearchService.alertForFoundMiscreant(people_3);

        // Then
        assertThat(miscreantOpt_1).contains(currentMiscreantArray[0]);
        assertThat(miscreantOpt_2).contains(currentMiscreantArray[1]);
        assertThat(miscreantOpt_3).isEmpty();

        then(this.alertService).should().sendAlert(currentMiscreantArray[0]);
        then(this.alertService).should().sendAlert(currentMiscreantArray[1]);
    }

}///:~