//: refactoring.catalog.api.domain.service.ShippingCostService


package refactoring.catalog.api.domain.service;


import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import refactoring.catalog.api.domain.model.Order;


@RequiredArgsConstructor(staticName = "of")
class ShippingCostService {

    private final IShippingRuleService shippingRuleService;

    int calculateShippingCosts(@NonNull final Order order) {
        final int shippingRules = this.shippingRuleService.localShippingRules(
                order.country());
        if (shippingRules < 0) {
            return shippingRules;
        }
        return shippingRules * 100;
    }

}///:~