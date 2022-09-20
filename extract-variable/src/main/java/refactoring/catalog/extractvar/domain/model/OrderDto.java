package refactoring.catalog.extractvar.domain.model;


import lombok.*;


@Getter
@ToString
@EqualsAndHashCode
public class OrderDto {

    private final long quantity;
    private final long itemPrice;

    private OrderDto(Order order) {
        this.quantity = order.getQuantity();
        this.itemPrice = order.getItemPrice();
    }

    public static OrderDto of(@NonNull final Order order) {
        return new OrderDto(order);
    }

    public long getOrderPrice() {
        return getBasePrice() - getQuantityDiscount() + getShippingPrice();
    }

    long getBasePrice() {
        return quantity * itemPrice;
    }

    long getQuantityDiscount() {
        return Math.max(0, quantity - 500) * itemPrice * 2;
    }

    long getShippingPrice() {
        return Math.min(getBasePrice() * 10, 10000);
    }

}
