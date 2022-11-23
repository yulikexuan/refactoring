//: refactoring.catalog.slide.statements.domain.model.Order


package refactoring.catalog.slide.statements.domain.model;


import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;

import javax.annotation.concurrent.ThreadSafe;


@Value
@ThreadSafe
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
public class Order {

    int units;

    boolean repeat;

    public boolean isRepeat() {
        return this.repeat();
    }

}///:~