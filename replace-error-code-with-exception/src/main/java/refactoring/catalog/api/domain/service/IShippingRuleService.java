//: refactoring.catalog.api.domain.service.IShippingRuleService


package refactoring.catalog.api.domain.service;


import lombok.NonNull;


public interface IShippingRuleService {

    int LOCAL_SHIPPING_RULE_ERROR_CODE = -23;

    int localShippingRules(@NonNull String country);

}///:~