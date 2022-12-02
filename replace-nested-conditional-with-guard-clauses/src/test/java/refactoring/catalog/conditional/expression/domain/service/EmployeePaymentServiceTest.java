package refactoring.catalog.conditional.expression.domain.service;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import refactoring.catalog.conditional.expression.domain.model.Employee;
import refactoring.catalog.conditional.expression.domain.model.Payment;
import refactoring.catalog.conditional.expression.domain.model.Payment.State;

import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test class EmployeePaymentService - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class EmployeePaymentServiceTest {

    @Mock(lenient = true)
    private FinancingService financingService;

    private IEmployeePaymentService paymentServiceInit;

    private IEmployeePaymentService paymentServiceRefactor;

    private Employee employee;

    @BeforeEach
    void setUp() {
        this.paymentServiceInit = EmployeePaymentServiceInit.of(
                this.financingService);
        this.paymentServiceRefactor = EmployeePaymentServiceRefactor.of(
                this.financingService);
    }

    @ParameterizedTest
    @CsvSource({ "true, true, 0, SEP",
            "false, true, 0, RET",
            "false, false, 3000, EMPLOYED" })
    void able_To_Calculate_Payment_For_Employee(boolean separated,
                                                boolean retired,
                                                long amount,
                                                State state) {

        // Given
        this.employee = Employee.of(separated, retired);

        given(this.financingService.computation()).willReturn(amount);

        // When
        Payment actualPaymentInit = this.paymentServiceInit.payAmount(employee);
        Payment actualPaymentRefactor = this.paymentServiceRefactor.payAmount(employee);

        // Then
        assertThat(actualPaymentInit).isEqualTo(Payment.of(amount, state));
        assertThat(actualPaymentRefactor).isEqualTo(Payment.of(amount, state));
    }

}///:~