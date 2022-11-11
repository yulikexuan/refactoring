//: refactoring.catalog.replace.temp.domain.model.Order


package refactoring.catalog.replace.temp.domain.model;


import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;


@Value
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
public class Order {

    static final int DEFAULT_DISCOUNT_FACTOR = 98;

    static final long BASE_PRICE_THRESHOLD = 100000;

    static final int DISCOUNT_FACTOR_UNIT = 3;

    Item item;

    int quantity;

    public long price() {
        return basePrice() * discountFactor() / 100;
    }

    long basePrice() {
        return quantity * item.price();
    }

    int discountFactor() {
        return (basePrice() > BASE_PRICE_THRESHOLD) ?
                DEFAULT_DISCOUNT_FACTOR - DISCOUNT_FACTOR_UNIT :
                DEFAULT_DISCOUNT_FACTOR;
    }

}///:~