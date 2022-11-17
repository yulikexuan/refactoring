package refactoring.catalog.move.field.domain.model;


import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import static org.mutabilitydetector.unittesting.MutabilityAssert.assertImmutable;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test Customer class - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class CustomerTest {

    private Customer customer;

    private String name;

    @BeforeEach
    void setUp() {
        this.name = RandomStringUtils.randomAlphanumeric(7);
    }

    @Test
    void class_Customer_Should_Be_Immutable() {
        assertImmutable(Customer.class);
    }

    @ParameterizedTest
    @CsvSource({"1, 4", "2, 5", "3, 6", "4, 7", "5, 8"})
    void customer_Can_Become_Preferred(int discountRate, int preferredDiscountRate) {

        // Given
        this.customer = Customer.newCustomer(this.name, discountRate);

        // When
        Customer preferred = Customer.becomePreferred(this.customer);

        // Then
        assertThat(preferred).isNotSameAs(this.customer);
        assertThat(preferred.discountRate()).isEqualTo(preferredDiscountRate);
    }

    @ParameterizedTest
    @CsvSource({"1, 100, 99", "3, 110, 107", "5, 70, 67", "6, 30, 29", "7, 200, 186"})
    void able_To_Apply_Discount_To_Amount(int discountRate,
                                          long amount,
                                          long finalCost) {

        // Given
        this.customer = Customer.newCustomer(this.name, discountRate);

        // When
        long actualFinalCost = this.customer.applyDiscount(amount);

        // Then
        assertThat(actualFinalCost).isEqualTo(finalCost);
    }

}///:~