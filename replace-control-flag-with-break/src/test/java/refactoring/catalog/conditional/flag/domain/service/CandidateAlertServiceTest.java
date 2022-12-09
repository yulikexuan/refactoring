package refactoring.catalog.conditional.flag.domain.service;


import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import refactoring.catalog.conditional.flag.domain.model.Alert;
import refactoring.catalog.conditional.flag.domain.model.IPerson;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test class CandidateAlertService - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class CandidateAlertServiceTest {

    @Mock
    private Alert alert;

    private ICandidateAlertService alertService;

    private String candidate_1;
    private String candidate_2;

    @BeforeEach
    void setUp() {
        this.alertService = CandidateAlertServiceRefactor.of(this.alert);
        this.candidate_1 = name();
        this.candidate_2 = name();
    }

    @Test
    void able_To_Find_Out_Candidates_With_Sending_Alert() {

        // Given
        List<IPerson> people_1 = List.of(
                IPerson.of(name(), 30),
                IPerson.of(name(), 31),
                IPerson.of(this.candidate_1, 43),
                IPerson.of(name(), 28),
                IPerson.of(this.candidate_2, 56),
                IPerson.of(this.candidate_1, 22),
                IPerson.of(name(), 19));

        List<IPerson> people_2 = List.of(
                IPerson.of(name(), 30),
                IPerson.of(name(), 31),
                IPerson.of(name(), 28),
                IPerson.of(name(), 19));

        // When
        Optional<IPerson> actualMiscreantOpt_1 = this.alertService.checkForMiscreants(
                people_1, candidate_1, candidate_2);

        Optional<IPerson> actualMiscreantOpt_2 = this.alertService.checkForMiscreants(
                people_2, candidate_1, candidate_2);

        // Then
        assertThat(actualMiscreantOpt_1).isNotEmpty();
        assertThat(actualMiscreantOpt_1.get().name()).isEqualTo(candidate_1);

        assertThat(actualMiscreantOpt_2).isEmpty();
        then(this.alert).should(times(1))
                .sendAlert(candidate_1);
    }

    private String name() {
        return RandomStringUtils.randomAlphabetic(7);
    }

}///:~