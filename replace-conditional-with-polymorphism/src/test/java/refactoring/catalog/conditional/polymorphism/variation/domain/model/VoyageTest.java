package refactoring.catalog.conditional.polymorphism.variation.domain.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mutabilitydetector.unittesting.AllowedReason;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import static org.mockito.BDDMockito.given;
import static org.mutabilitydetector.unittesting.MutabilityAssert.assertImmutable;
import static org.mutabilitydetector.unittesting.MutabilityAssert.assertInstancesOf;
import static org.mutabilitydetector.unittesting.MutabilityMatchers.areImmutable;
import static refactoring.catalog.conditional.polymorphism.variation.domain.model.IVoyage.ZONE_CHINA;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test class  Voyage - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class VoyageTest {

    @Mock(lenient = true)
    private IVoyageHistory history;

    private Voyage voyage;

    private IVoyageRating voyageRating;

    @BeforeEach
    void setUp() {
    }

    @Test
    void class_Voyage_Should_Be_Immutable() {
        assertImmutable(Voyage.class);
    }

    @Test
    void class_VoyageRating_Should_Be_Immutable() {
        assertInstancesOf(GenericVoyageRating.class,
                areImmutable(),
                AllowedReason.provided(IVoyage.class).isAlsoImmutable(),
                AllowedReason.provided(IVoyageHistory.class).isAlsoImmutable());
        assertInstancesOf(ExperiencedChinaVoyageRating.class,
                areImmutable(),
                AllowedReason.provided(IVoyage.class).isAlsoImmutable(),
                AllowedReason.provided(IVoyageHistory.class).isAlsoImmutable());
    }

    @ParameterizedTest
    @CsvSource({
            "19, china, 1000, 18",
            "3, quebec, 1000, 1",
            "4, quebec, 1000, 1",
            "5, quebec, 1000, 3",
            "8, east-indies, 1000, 7",
            "9, quebec, 1000, 4",
            "10, china, 1000, 9",
            "12, east-indies, 1000, 11"})
    void voyage_Has_Risk(int length,
                         String zone,
                         long profit,
                         int expectedRisk) {

        // Given
        this.voyage = Voyage.of(length, zone, profit);
        this.voyageRating = IVoyageRating.of(voyage, history);

        // When
        int risk = this.voyageRating.voyageRisk();

        // Then
        assertThat(risk).isEqualTo(expectedRisk);
    }

    @ParameterizedTest
    @CsvSource({
            "19, china, 1000, 4, 0, false, 5",
            "3, cuba, 1000, 4, 0, false, 5",
            "3, cuba, 1000, 5, 0, false, 1",
            "3, cuba, 1000, 6, 0, false, 1",
            "3, cuba, 1000, 7, 2, false, 3",
            "3, cuba, 1000, 7, 3, false, 4",
            "3, cuba, 1000, 6, 0, true, 1",
            "3, china, 1000, 6, 0, true, 0",
            "3, china, 1000, 3, 2, true, 5",
            "3, china, 1000, 3, 2, false, 7",
    })
    void captain_Has_History_Risk(int length,
                                  String zone,
                                  long profit,
                                  int lengthOfHistory,
                                  int countOfLoss,
                                  boolean hasChinaDestination,
                                  int expectedRisk) {

        // Given
        this.voyage = Voyage.of(length, zone, profit);

        given(this.history.length()).willReturn(lengthOfHistory);
        given(this.history.countOfLoss()).willReturn(countOfLoss);
        given(this.history.hasDestination(ZONE_CHINA))
                .willReturn(hasChinaDestination);

        this.voyageRating = IVoyageRating.of(voyage, history);

        // When
        int actualRisk =this.voyageRating.captainHistoryRisk();

        // Then
        assertThat(actualRisk).isEqualTo(expectedRisk);
    }

    @ParameterizedTest
    @CsvSource({
            "19, china, 1000, 11, 0, true, 7",
            "19, east-indies, 1000, 11, 0, true, 3",
            "19, china, 1000, 11, 0, false, 3",
            "14, china, 1000, 8, 0, false, 3",
            "19, cuba, 1000, 11, 0, true, 2",
            "19, cuba, 1000, 8, 0, true, 1",
            "14, cuba, 1000, 8, 0, true, 2",
            "12, china, 1000, 10, 0, true, 6",
            "18, china, 1000, 10, 0, true, 7",
    })
    void able_To_Calculate_Voyage_Profit_Factor(int length,
                                                String zone,
                                                long profit,
                                                int lengthOfHistory,
                                                int countOfLoss,
                                                boolean hasChinaDestination,
                                                int expectedProfitFactor) {

        // Given
        this.voyage = Voyage.of(length, zone, profit);

        given(this.history.hasDestination(ZONE_CHINA))
                .willReturn(hasChinaDestination);

        given(this.history.length()).willReturn(lengthOfHistory);

        this.voyageRating = IVoyageRating.of(voyage, history);

        // When
        int actualVoyageProfitFactor = this.voyageRating.voyageProfitFactor();

        // Then
        assertThat(actualVoyageProfitFactor).isEqualTo(expectedProfitFactor);
    }

    @ParameterizedTest
    @CsvSource({
            "19, china, 1000, 11, 0, true, A",
            "19, cuba, 1000, 11, 0, true, B",
            "19, east-indies, 1000, 11, 0, true, B",
            "9, east-indies, 1000, 11, 0, true, A",
    })
    void able_To_Give_Voyage_A_Rating(int length,
                                      String zone,
                                      long profit,
                                      int lengthOfHistory,
                                      int countOfLoss,
                                      boolean hasChinaDestination,
                                      String expectedRating) {

        // Given
        this.voyage = Voyage.of(length, zone, profit);

        given(this.history.hasDestination(ZONE_CHINA))
                .willReturn(hasChinaDestination);

        given(this.history.length()).willReturn(lengthOfHistory);
        given(this.history.countOfLoss()).willReturn(countOfLoss);
        given(this.history.hasDestination(ZONE_CHINA))
                .willReturn(hasChinaDestination);

        this.voyageRating = IVoyageRating.of(voyage, history);

        // When
        String actualRating = this.voyageRating.rate();

        // Then
        assertThat(actualRating).isEqualTo(expectedRating);
    }

}///:~