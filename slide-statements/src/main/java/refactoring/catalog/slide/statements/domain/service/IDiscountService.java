//: refactoring.catalog.slide.statements.domain.service.IDiscountService


package refactoring.catalog.slide.statements.domain.service;


import lombok.NonNull;
import refactoring.catalog.slide.statements.domain.model.Order;
import refactoring.catalog.slide.statements.domain.model.PricingPlan;


public interface IDiscountService {

    long discount(PricingPlan pricingPlan, Order order);

}


final class DiscountService implements IDiscountService {

    @Override
    public long discount(@NonNull final PricingPlan pricingPlan,
                         @NonNull final Order order) {

        final int discountableUnits = Math.max(
                (order.units() - pricingPlan.discountThreshold()), 0);

        long discount = discountableUnits * pricingPlan.discountFactor() / 100;

        if (order.isRepeat()) {
            discount += 20;
        }

        return discount;
    }

}///:~