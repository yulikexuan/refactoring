package refactoring.catalog.conditional.special.refactor.domain.model;


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
import refactoring.catalog.conditional.special.initial.domain.model.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import static org.mockito.BDDMockito.given;
import static org.mutabilitydetector.unittesting.MutabilityAssert.assertInstancesOf;
import static org.mutabilitydetector.unittesting.MutabilityMatchers.areImmutable;
import static refactoring.catalog.conditional.special.initial.domain.model.BillingPlan.BASIC;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test SiteRefactor Class - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class SiteRefactorTest {

    @Mock(lenient = true)
    private IPaymentHistory paymentHistory;

    private ICustomerRefactor customer;

    private SiteRefactor site;

    @BeforeEach
    void setUp() {
    }

    @Test
    void class_CustomerRefactor_Should_Be_Immutable() {
        assertInstancesOf(CustomerRefactor.class,
                areImmutable(),
                AllowedReason.provided(IPaymentHistory.class).isAlsoImmutable());
    }

    @Test
    void class_UnknownCustomer_Should_Be_Immutable() {
        assertInstancesOf(UnknownCustomer.class,
                areImmutable(),
                AllowedReason.provided(IPaymentHistory.class).isAlsoImmutable());
    }

    @ParameterizedTest
    @CsvSource({ "unknown, occupant", "name1, name1", "aksjhm, aksjhm" })
    void site_Has_Display_Name(String customerName, String expectedDisplayName) {

        // Given
        this.customer = ICustomerRefactor.of(customerName, BASIC, paymentHistory);

        this.site = SiteRefactor.of(this.customer);

        // When
        String actualDisplayName = this.site.displayName();

        // Then
        assertThat(actualDisplayName).isEqualTo(expectedDisplayName);
    }

    @ParameterizedTest
    @CsvSource({ "unknown, BASIC, BASIC",
            "unknown, ADVANCE, BASIC",
            "unknown, VIP, BASIC",
            "aksjh345m, BASIC, BASIC",
            "aks456jhm, ADVANCE, ADVANCE",
            "aksjtuhm, VIP, VIP",
    })
    void site_Displays_Correct_Billing_Plan(String customerName,
                                            BillingPlan customerBillingPlan,
                                            BillingPlan expectedDisplayBillingPlan) {

        // Given
        this.customer = ICustomerRefactor.of(
                customerName, customerBillingPlan, paymentHistory);

        this.site = SiteRefactor.of(this.customer);

        // When
        BillingPlan actualDisplayBillingPlan = this.site.displayBillingPlan();

        // Then
        assertThat(actualDisplayBillingPlan).isEqualTo(expectedDisplayBillingPlan);
    }

    @ParameterizedTest
    @CsvSource({ "unknown, BASIC, ADVANCE, BASIC",
            "unknown, ADVANCE, BASIC, BASIC",
            "unknown, VIP, ADVANCE, BASIC",
            "aksjh345m, BASIC, ADVANCE, ADVANCE",
            "aks456jhm, ADVANCE, VIP, VIP",
            "aksjtuhm, VIP, ADVANCE, ADVANCE",
    })
    void able_To_Update_Billing_Plan_For_Customer(
            String customerName,
            BillingPlan customerBillingPlan,
            BillingPlan newCustomerBillingPlan,
            BillingPlan expectedCustomerBillingPlan) {

        // Given
        this.customer = ICustomerRefactor.of(
                customerName, customerBillingPlan, paymentHistory);
        this.site = SiteRefactor.of(this.customer);

        // When
        this.site.updateBillingPlan(newCustomerBillingPlan);
        BillingPlan actualCustomerBillingPlan = this.site.customerBillingPlan();

        // Then
        assertThat(actualCustomerBillingPlan).isEqualTo(expectedCustomerBillingPlan);
    }

    @ParameterizedTest
    @CsvSource({ "unknown, 12, 0",
            "unknown, 6, 0",
            "unknown, 1, 0",
            "unknown, 0, 0",
            "aksjh345m, 12, 12",
            "aks456jhm, 6, 6",
            "aksjtuhm, 1, 1",
            "aksjtsdfuhm, 0, 0",
    })
    void able_To_Display_Amount_Of_Weeks_Delinquent(String customerName,
                                                    int weeksDelinquent,
                                                    int expectedWeeksDelinquent) {

        // Given
        given(this.paymentHistory.weeksDelinquentInLastYear())
                .willReturn(weeksDelinquent);
        this.customer = ICustomerRefactor.of(customerName, BASIC, paymentHistory);

        this.site = SiteRefactor.of(this.customer);

        // When
        int actualWeeksDelinquent = this.site.displayWeeksDelinquent();

        // Then
        assertThat(actualWeeksDelinquent).isEqualTo(expectedWeeksDelinquent);
    }

}///:~