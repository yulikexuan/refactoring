//: refactoring.catalog.api.domain.service.ShippingRuleService


package refactoring.catalog.api.domain.service;


import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.Objects;


@RequiredArgsConstructor(staticName = "of")
class ShippingRuleService implements IShippingRuleService {

    private final Map<String, Integer> shippingRules;

    @Override
    public int localShippingRules(@NonNull final String country) {
        final Integer rule = this.shippingRules.get(country);
        if (Objects.nonNull(rule)) {
            return rule;
        } else {
            return LOCAL_SHIPPING_RULE_ERROR_CODE;
        }
    }

}///:~