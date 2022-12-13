//: refactoring.catalog.api.flag.arg.domain.model.Order


package refactoring.catalog.api.flag.arg.domain.model;


import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;

import javax.annotation.concurrent.ThreadSafe;
import java.time.LocalDate;


@Value
@ThreadSafe
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
public class Order {

    State deliveryState;

    LocalDate placeOn;

}///:~