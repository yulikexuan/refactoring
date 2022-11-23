//: refactoring.catalog.slide.statements.domain.service.OrderChargeService


package refactoring.catalog.slide.statements.domain.service;


import lombok.AllArgsConstructor;
import refactoring.catalog.slide.statements.domain.model.Order;
import refactoring.catalog.slide.statements.domain.model.OrderFactory;
import refactoring.catalog.slide.statements.domain.model.PricingPlan;
import refactoring.catalog.slide.statements.domain.model.PricingPlanFactory;

import javax.annotation.concurrent.ThreadSafe;


@ThreadSafe
@AllArgsConstructor(staticName = "of")
public class OrderChargeService {

    private final PricingPlanFactory pricingPlanFactory;

    private final OrderFactory orderFactory;

    private final ChargeService chargeService;

    private final IDiscountService discountService;

    public long chargeOrder() {

        final PricingPlan pricingPlan =
                this.pricingPlanFactory.retrievePricingPlan();

        final Order order = this.orderFactory.retrieveOrder();

        long charge = pricingPlan.baseCharge() +
                order.units() * pricingPlan.chargePerUnit() -
                discountService.discount(pricingPlan, order);

        return this.chargeService.chargeOrder(charge);
    }

}///:~