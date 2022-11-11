//: refactoring.catalog.replace.temp.domain.model.Item


package refactoring.catalog.replace.temp.domain.model;


import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;


@Value
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
public class Item {

    String name;

    long price;

}///:~