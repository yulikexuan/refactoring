//: refactoring.catalog.api.domain.service.ShippingServiceRefactor


package refactoring.catalog.api.domain.service;


import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import refactoring.catalog.api.domain.model.Order;
import refactoring.catalog.api.domain.model.OrderError;

import java.util.List;

import static refactoring.catalog.api.domain.service.IShippingRuleService.LOCAL_SHIPPING_RULE_ERROR_CODE;


@Slf4j
@RequiredArgsConstructor(staticName = "of")
class ShippingServiceRefactor implements IShippingService {

    private List<OrderError> errorList = Lists.newArrayList();

    private final ShippingCostService costService;

    @Override
    public void shipping(@NonNull final Order order) {

        try {
            costService.calculateShippingCosts(order);
        } catch (InvalidCountryException ice) {
            this.errorList.add(OrderError.of(
                    order, LOCAL_SHIPPING_RULE_ERROR_CODE));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        log.debug(">>> Perform shipping ... ");
    }

    @Override
    public List<OrderError> errorList() {
        return ImmutableList.copyOf(this.errorList);
    }

}///:~