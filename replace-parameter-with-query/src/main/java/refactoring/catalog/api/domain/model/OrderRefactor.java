//: refactoring.catalog.api.domain.model.OrderRefactor


package refactoring.catalog.api.domain.model;


import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;

import javax.annotation.concurrent.ThreadSafe;


@Value
@ThreadSafe
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
class OrderRefactor {

    int quantity;

    long itemPrice;

    long finalPrice() {
        return this.discountedPrice();
    }

    long basePrice() {
        return this.quantity * this.itemPrice;
    }

    int discountLevel() {
        return quantity > 100 ? 2 : 1;
    }

    long discountedPrice() {

        return switch (discountLevel()) {
            case 1 -> basePrice() * 95 / 100;
            case 2 -> basePrice() * 90 / 100;
            default -> basePrice();
        };
    }

}///:~