package refactoring.catalog.splitphase.domain.model;


import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.Accessors;


public sealed interface OrderPrice permits OrderPriceImpl {

    Order order();

    int price();

    static OrderPrice of(@NonNull final Product product,
                         @NonNull final int quantity,
                         @NonNull final ShippingMethod shippingMethod) {

        final Order order = Order.of(product, quantity);
        final ProductPrice productPrice = ProductPrice.of(order);

        final int basePrice = productPrice.basePrice();

        final int shippingPerCase = (basePrice > shippingMethod.discountThreshold()) ?
                shippingMethod.discountedFee() : shippingMethod.feePerCase();

        final int shippingCost = productPrice.quantity() * shippingPerCase;

        final int price = basePrice - productPrice.discount() + shippingCost;

        return OrderPriceImpl.of(order, price);
    }

}


@Value
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
final class OrderPriceImpl implements OrderPrice {

    Order order;

    int price;
}
