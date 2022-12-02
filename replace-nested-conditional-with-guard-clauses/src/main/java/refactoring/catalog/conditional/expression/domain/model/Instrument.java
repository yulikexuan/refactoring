//: refactoring.catalog.conditional.expression.domain.model.Instrument


package refactoring.catalog.conditional.expression.domain.model;


import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;

import javax.annotation.concurrent.ThreadSafe;


@Value
@ThreadSafe
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
public class Instrument {

    long capital;

    int interestRate;

    int duration;

    long income;

    int adjustmentFactor;

}///:~