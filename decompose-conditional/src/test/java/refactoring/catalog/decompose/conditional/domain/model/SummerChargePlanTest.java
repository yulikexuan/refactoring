package refactoring.catalog.decompose.conditional.domain.model;


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

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import static org.mockito.BDDMockito.given;
import static org.mutabilitydetector.unittesting.MutabilityAssert.assertInstancesOf;
import static org.mutabilitydetector.unittesting.MutabilityMatchers.areImmutable;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test class ChargePlan - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class SummerChargePlanTest {

    @Mock(lenient = true)
    private IChargePlan chargePlan;

    private InitialSummerChargePlan summerChargePlan;

    private SummerChargePlanRefactor summerChargePlanRefactor;

    @BeforeEach
    void setUp() {
    }

    @Test
    void class_SummerChargePlan_Should_Be_Immutable() {
        assertInstancesOf(InitialSummerChargePlan.class, areImmutable(),
                AllowedReason.provided(IChargePlan.class).isAlsoImmutable());
    }

    @ParameterizedTest
    @CsvSource({
            "2022, 6, 24, 8, 31, 7, 15, 90, 78, 85, 70, 70", // In Summer
            "2022, 6, 24, 8, 31, 7, 15, 95, 87, 85, 70, 82", // In Summer
            "2022, 6, 24, 8, 31, 5, 27, 95, 87, 85, 70, 143", // Before Summer
            "2022, 6, 24, 8, 31, 11, 30, 90, 78, 80, 89, 151", // After Summer
    })
    void able_To_Calculate_Total_Charge_With_Summer_Plan(
            int year, int startMonth, int startDay,
            int endMonth, int endDay,
            int todayMonth, int today,
            long summerRate, long quantity,
            long regularRate, long regularServiceCharge,
            long expectedCharge) {

        // Given
        LocalDate summerStart = LocalDate.of(year, startMonth, startDay);
        LocalDate summerEnd = LocalDate.of(year, endMonth, endDay);
        LocalDate aDate = LocalDate.of(year, todayMonth, today);

        given(this.chargePlan.regularRate()).willReturn(regularRate);
        given(this.chargePlan.regularServiceCharge()).willReturn(regularServiceCharge);

        this.summerChargePlan = InitialSummerChargePlan.of(
                chargePlan, summerStart, summerEnd, summerRate);

        this.summerChargePlanRefactor = SummerChargePlanRefactor.of(
                chargePlan, summerStart, summerEnd, summerRate);

        // When
        long actualInitialCharge = this.summerChargePlan.charge(quantity, aDate);

        long actualRefactorCharge = this.summerChargePlanRefactor.charge(
                quantity, aDate);

        // Then
        assertThat(actualInitialCharge).isEqualTo(expectedCharge);
        assertThat(actualRefactorCharge).isEqualTo(expectedCharge);
    }

}///:~