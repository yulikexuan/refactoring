package refactoring.catalog.extractvar.domain.service;


import lombok.NonNull;
import refactoring.catalog.extractvar.domain.model.Order;


public class OrderPriceService {

    long getOrderPrice(@NonNull final Order order) {

        return order.getQuantity() * order.getItemPrice() -
                Math.max(0, order.getQuantity() - 500) * order.getItemPrice() * 2 +
                Math.min(order.getQuantity() * order.getItemPrice() * 10, 10000);
    }

}