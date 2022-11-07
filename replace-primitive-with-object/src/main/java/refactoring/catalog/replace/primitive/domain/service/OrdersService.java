package refactoring.catalog.replace.primitive.domain.service;


import lombok.NonNull;
import refactoring.catalog.replace.primitive.domain.model.Order;

import java.util.List;


public interface OrdersService {

    static long countHighPriorityOrders(@NonNull final List<Order> orders) {
        return orders.stream()
                .map(Order::priority)
                .filter(p -> "high".equals(p) || "rush".equals(p))
                .count();
    }

}