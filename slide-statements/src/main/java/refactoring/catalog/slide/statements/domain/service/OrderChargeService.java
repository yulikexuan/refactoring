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

    public long chargeOrder() {

        final PricingPlan pricingPlan = this.pricingPlanFactory.retrievePricingPlan();

        final Order order = this.orderFactory.retrieveOrder();

        final long baseCharge = pricingPlan.baseCharge();

        long charge = 0;

        final long chargePerUnit = pricingPlan.chargePerUnit();

        final int units = order.units();

        long discount = 0;

        charge = baseCharge + units * chargePerUnit;

        int discountableUnits = Math.max(
                (units - pricingPlan.discountThreshold()), 0);

        discount = discountableUnits * pricingPlan.discountFactor() / 100;

        if (order.isRepeat()) {
            discount += 20;
        }

        charge = charge - discount;

        return this.chargeService.chargeOrder(charge);
    }

}///:~