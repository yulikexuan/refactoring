package refactoring.catalog.replace.loop.domain.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test class ReaderService - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class ReaderServiceTest {

    @Mock
    private BookReadingService bookReadingService;

    private ReaderService readerService;

    @BeforeEach
    void setUp() {
        this.readerService = ReaderService.of(this.bookReadingService);
    }

    @Test
    void able_To_Know_Which_Books_Are_Read_By_Readers_On_A_Date() {

        // Given
        List<String> readers = List.of("AAA", "BBB", "CCC", "DDD", "EEE",
                "FFF", "GGG", "HHH", "III");
        List<String> books = List.of("ABC", "BCD", "CDE", "DEF",
                "EFG", "FGH", "GHI", "HIJ", "IJK", "JKL", "KLM", "LMN", "MNO");

        LocalDate targetDate = LocalDate.now();

        Map<String, List<String>> readingData = Map.of(
                "BBB", List.of("BCD", "LMN"),
                "SSS", List.of("IJK", "XYZ"),
                "AAA", List.of("ABC", "KK-QQ-PP"),
                "ZZZ", List.of("FGH"),
                "GGG", List.of("FGH_FGH"),
                "FFF", List.of("HIJ"));

        given(this.bookReadingService.readingDataOnDate(targetDate))
                .willReturn(readingData);

        // When
        Set<String> candidateReaders = this.readerService.booksReadOn(
                readers, books, targetDate);

        // Then
        assertThat(candidateReaders).containsExactlyInAnyOrder(
                "AAA", "BBB", "FFF");
    }

}///:~