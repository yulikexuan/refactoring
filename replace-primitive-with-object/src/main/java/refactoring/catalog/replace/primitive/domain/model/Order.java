//: refactoring.catalog.replace.primitive.domain.model.Order


package refactoring.catalog.replace.primitive.domain.model;


import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;


@Value
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
public class Order {

    String id;

    String priority;

}///:~