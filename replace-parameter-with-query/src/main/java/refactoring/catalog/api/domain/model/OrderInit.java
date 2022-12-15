//: refactoring.catalog.api.domain.model.Order


package refactoring.catalog.api.domain.model;


import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;

import javax.annotation.concurrent.ThreadSafe;


@Value
@ThreadSafe
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
class OrderInit {

    int quantity;

    long itemPrice;

    long finalPrice() {

        long basePrice = this.quantity * this.itemPrice;

        int discountLevel = 0;
        if (this.quantity > 100) {
            discountLevel = 2;
        } else {
            discountLevel = 1;
        }

        return this.discountedPrice(basePrice, discountLevel);
    }

    private long discountedPrice(long basePrice, int discountLevel) {

        return switch (discountLevel) {
            case 1 -> basePrice * 95 / 100;
            case 2 -> basePrice * 90 / 100;
            default -> basePrice;
        };
    }

}///:~