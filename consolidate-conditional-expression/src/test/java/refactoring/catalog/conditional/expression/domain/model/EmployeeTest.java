package refactoring.catalog.conditional.expression.domain.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;


@DisplayName("Test class Employee - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class EmployeeTest {

    private EmployeeRefactor employee;

    @BeforeEach
    void setUp() {
    }

    @ParameterizedTest
    @CsvSource({
            "1, 0, false, false, 0, 50",
            "3, 13, false, false, 0, 50",
            "3, 6, true, false, 0, 50",
            "3, 6, false, false, 24, 50",
            "7, 10, false, false, 60, 50",
            "7, 10, false, true, 60, 50",
            "17, 10, false, true, 160, 100"})
    void able_To_Calculate_Disability_Amount(
            int seniority, int monthsDisabled, boolean partTime, boolean onVacation,
            int expectedDisabilityAmount, int expectedPaymentRate) {

        // Given
        this.employee = EmployeeRefactor.of(
                seniority, monthsDisabled, partTime, onVacation);

        // When
        int actualDisabilityAmount = this.employee.disabilityAmount();
        int actualPaymentRate = this.employee.paymentRate();

        // Then
        assertThat(actualDisabilityAmount).isEqualTo(expectedDisabilityAmount);
        assertThat(actualPaymentRate).isEqualTo(expectedPaymentRate);
    }

}///:~