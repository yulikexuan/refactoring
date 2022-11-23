package refactoring.catalog.slide.statements.domain.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import refactoring.catalog.slide.statements.domain.model.Order;
import refactoring.catalog.slide.statements.domain.model.OrderFactory;
import refactoring.catalog.slide.statements.domain.model.PricingPlan;
import refactoring.catalog.slide.statements.domain.model.PricingPlanFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import static org.mockito.BDDMockito.given;
import static org.mutabilitydetector.unittesting.MutabilityAssert.assertImmutable;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test class OrderChargeService - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class OrderChargeServiceTest {

    @Mock
    private PricingPlanFactory pricingPlanFactory;

    @Mock
    private OrderFactory orderFactory;

    @Mock
    private ChargeService chargeService;

    @Mock
    private IDiscountService discountService;

    private OrderChargeService orderChargeService;

    private PricingPlan pricingPlan;

    private Order order;

    @BeforeEach
    void setUp() {
        this.orderChargeService = OrderChargeService.of(
                this.pricingPlanFactory,
                this.orderFactory,
                this.chargeService,
                this.discountService);
    }

    @Test
    void class_PricingPlan_Should_Be_Immutable() {
        assertImmutable(PricingPlan.class);
    }

    @Test
    void class_Order_Should_Be_Immutable() {
        assertImmutable(Order.class);
    }

    @ParameterizedTest
    @CsvSource({"25, 99, 10, 2, 88, true, 21, 8716",
            "36, 77, 7, 3, 66, false, 1, 5117",
            "55, 32, 3, 2, 60, true, 20, 1955"})
    void able_To_Charge_An_Order(
            long baseCharge,
            long chargePerUnit,
            int discountThreshold,
            int discountFactor,
            int units,
            boolean repeat,
            long discount,
            long expectedCharge) {

        // Given
        this.pricingPlan = PricingPlan.of(
                baseCharge, chargePerUnit, discountThreshold, discountFactor);

        this.order = Order.of(units, repeat);

        given(pricingPlanFactory.retrievePricingPlan()).willReturn(pricingPlan);

        given(orderFactory.retrieveOrder()).willReturn(order);

        given(this.discountService.discount(pricingPlan, order))
                .willReturn(discount);

        given(this.chargeService.chargeOrder(expectedCharge))
                .willReturn(expectedCharge);

        // When
        long actualCharge = this.orderChargeService.chargeOrder();

        // Then
        assertThat(actualCharge).isEqualTo(expectedCharge);
    }

}///:~