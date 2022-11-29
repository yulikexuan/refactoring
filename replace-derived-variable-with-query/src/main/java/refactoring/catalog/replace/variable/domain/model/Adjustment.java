//: refactoring.catalog.replace.variable.domain.model.Adjustment


package refactoring.catalog.replace.variable.domain.model;


import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;

import javax.annotation.concurrent.ThreadSafe;
import java.time.LocalDate;


@Value
@ThreadSafe
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
class Adjustment {

    long amount;

    LocalDate date;

}///:~