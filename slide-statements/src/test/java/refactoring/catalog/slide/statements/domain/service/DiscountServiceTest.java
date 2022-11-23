package refactoring.catalog.slide.statements.domain.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;
import refactoring.catalog.slide.statements.domain.model.Order;
import refactoring.catalog.slide.statements.domain.model.PricingPlan;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test class  DiscountService- ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class DiscountServiceTest {

    private PricingPlan pricingPlan;

    private Order order;

    private DiscountService discountService;

    @BeforeEach
    void setUp() {
        this.discountService = new DiscountService();
    }

    @ParameterizedTest
    @CsvSource({"25, 99, 10, 2, 88, true, 21",
            "36, 77, 7, 3, 66, false, 1",
            "99, 12, 3, 2, 8, true, 20"})
    void able_To_Calculate_Discount(long baseCharge,
                                    long chargePerUnit,
                                    int discountThreshold,
                                    int discountFactor,
                                    int units,
                                    boolean repeat,
                                    long expectedDiscount) {

        // Given
        this.pricingPlan = PricingPlan.of(
                baseCharge, chargePerUnit, discountThreshold, discountFactor);

        this.order = Order.of(units, repeat);

        // When
        long actualDiscount = this.discountService.discount(pricingPlan, order);

        // Then
        assertThat(actualDiscount).isEqualTo(expectedDiscount);
    }

}///:~