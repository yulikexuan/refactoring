//: refactoring.catalog.splitphase.domain.model.Product


package refactoring.catalog.splitphase.domain.model;


import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;


@Value
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
public class Product {

    int basePrice;

    int discountThreshold;

    int discountRate;

}///:~