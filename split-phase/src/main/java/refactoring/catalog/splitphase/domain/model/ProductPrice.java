package refactoring.catalog.splitphase.domain.model;


import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.Accessors;

public sealed interface ProductPrice permits ProductPriceImpl {

    int basePrice();

    int discount();

    int quantity();

    static ProductPrice of(@NonNull final Order order) {

        final int productBasePrice = order.product().basePrice();

        final int quantity = order.quantity();

        final int basePrice = productBasePrice * quantity;

        int discountThreshold = order.product().discountThreshold();

        int discountRate = order.product().discountRate();

        final int discount = Math.max(quantity - discountThreshold, 0) *
                productBasePrice * discountRate / 100;

        return ProductPriceImpl.of(basePrice, discount, quantity);
    }
}

@Value
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
final class ProductPriceImpl implements ProductPrice  {

    int basePrice;

    int discount;

    int quantity;

}///:~