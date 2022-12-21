//: refactoring.catalog.api.domain.service.ShippingService


package refactoring.catalog.api.domain.service;


import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import refactoring.catalog.api.domain.model.Order;
import refactoring.catalog.api.domain.model.OrderError;

import java.util.List;


@Slf4j
@RequiredArgsConstructor(staticName = "of")
class ShippingService implements IShippingService {

    private List<OrderError> errorList = Lists.newArrayList();

    private final ShippingCostService costService;

    @Override
    public void shipping(@NonNull final Order order) {

        final int status = costService.calculateShippingCosts(order);

        if (status < 0) {
            this.errorList.add(OrderError.of(order, status));
        }

        log.debug(">>> Perform shipping ... ");
    }

    @Override
    public List<OrderError> errorList() {
        return ImmutableList.copyOf(this.errorList);
    }

}///:~