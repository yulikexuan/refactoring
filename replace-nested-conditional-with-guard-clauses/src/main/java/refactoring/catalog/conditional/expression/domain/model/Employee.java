//: refactoring.catalog.conditional.expression.domain.model.Employee


package refactoring.catalog.conditional.expression.domain.model;


import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;

import javax.annotation.concurrent.ThreadSafe;


@Value
@ThreadSafe
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
public class Employee {

    boolean separated;

    boolean retired;

}///:~