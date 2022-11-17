package refactoring.catalog.move.field.domain.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import static org.mutabilitydetector.unittesting.MutabilityAssert.assertImmutable;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test class CustomerContract- ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class CustomerContractTest {

    private int defaultDiscountRate;

    private CustomerContract contract;

    private ThreadLocalRandom random;

    @BeforeEach
    void setUp() {
        this.random = ThreadLocalRandom.current();
        this.defaultDiscountRate = this.random.nextInt(1, 5);
        this.contract = CustomerContract.newContract(this.defaultDiscountRate);
    }

    @Test
    void class_CustomerContract_Should_Be_Immutable() {
        assertImmutable(CustomerContract.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6, 7, 8, 9})
    void able_To_Update_To_A_New_Discount_Rate(int discountRate) {

        // Given

        // When
        CustomerContract newContract = CustomerContract.applyNewDiscountRate(
                this.contract, discountRate);

        // Then
        assertThat(this.contract.discountRate()).isEqualTo(this.defaultDiscountRate);
        assertThat(newContract.discountRate()).isEqualTo(discountRate);
    }

}///:~