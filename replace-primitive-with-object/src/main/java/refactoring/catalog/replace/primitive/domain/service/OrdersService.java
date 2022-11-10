package refactoring.catalog.replace.primitive.domain.service;


import lombok.NonNull;
import refactoring.catalog.replace.primitive.domain.model.Order;

import java.util.List;

import static refactoring.catalog.replace.primitive.domain.model.Priority.HIGH;
import static refactoring.catalog.replace.primitive.domain.model.Priority.RUSH;


public interface OrdersService {

    static long countHighPriorityOrders(@NonNull final List<Order> orders) {
        return orders.stream()
                .map(Order::priority)
                .filter(p -> p == HIGH || p == RUSH)
                .count();
    }

}