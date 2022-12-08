package refactoring.catalog.conditional.special.initial.domain.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mutabilitydetector.unittesting.AllowedReason;

import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import static org.mutabilitydetector.unittesting.MutabilityAssert.assertInstancesOf;
import static org.mutabilitydetector.unittesting.MutabilityMatchers.areImmutable;
import static refactoring.catalog.conditional.special.initial.domain.model.BillingPlan.BASIC;

@DisplayName("Test Class Site - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class SiteTest {

    private ICustomer customer;

    private IPaymentHistory paymentHistory;

    private ThreadLocalRandom random;

    private Site site;

    @BeforeEach
    void setUp() {
        this.random = ThreadLocalRandom.current();
        this.paymentHistory = PaymentHistory.of(
                this.random.nextInt(10, 52));
    }

    @Test
    void class_Customer_Should_Be_Immutable() {
        assertInstancesOf(Customer.class,
                areImmutable(),
                AllowedReason.provided(IPaymentHistory.class).isAlsoImmutable());
    }

    @ParameterizedTest
    @CsvSource({ "unknown, occupant", "name1, name1", "aksjhm, aksjhm" })
    void site_Has_Display_Name(String customerName, String expectedDisplayName) {

        // Given
        this.customer = ICustomer.of(customerName, BASIC, paymentHistory);

        this.site = Site.of(this.customer);

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
        this.customer = ICustomer.of(customerName, customerBillingPlan, paymentHistory);

        this.site = Site.of(this.customer);

        // When
        BillingPlan actualDisplayBillingPlan = this.site.displayBillingPlan();

        // Then
        assertThat(actualDisplayBillingPlan).isEqualTo(expectedDisplayBillingPlan);
    }

    @ParameterizedTest
    @CsvSource({ "unknown, BASIC, ADVANCE, BASIC",
            "unknown, ADVANCE, BASIC, ADVANCE",
            "unknown, VIP, ADVANCE, VIP",
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
        this.customer = ICustomer.of(customerName, customerBillingPlan, paymentHistory);
        this.site = Site.of(this.customer);

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
        this.paymentHistory = PaymentHistory.of(weeksDelinquent);
        this.customer = ICustomer.of(customerName, BASIC, paymentHistory);

        this.site = Site.of(this.customer);

        // When
        int actualWeeksDelinquent = this.site.displayWeeksDelinquent();

        // Then
        assertThat(actualWeeksDelinquent).isEqualTo(expectedWeeksDelinquent);
    }

}///:~