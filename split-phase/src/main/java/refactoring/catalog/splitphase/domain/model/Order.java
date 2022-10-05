//: refactoring.catalog.splitphase.domain.model.Order


package refactoring.catalog.splitphase.domain.model;


import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;


@Value
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
public class Order {

    Product product;

    int quantity;

}///:~