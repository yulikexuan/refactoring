package refactoring.catalog.extractvar.domain.service;


import lombok.NonNull;
import refactoring.catalog.extractvar.domain.model.Order;
import refactoring.catalog.extractvar.domain.model.OrderDto;


public class OrderPriceService {

    long getOrderPrice(@NonNull final Order order) {

        final OrderDto orderDto = OrderDto.of(order);

        return orderDto.getOrderPrice();
    }

}