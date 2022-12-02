package refactoring.catalog.conditional.expression.domain.model;


import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;

import javax.annotation.concurrent.ThreadSafe;


@Value
@ThreadSafe
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
public class Payment {

    long amount;

    State state;

    public enum State {
        SEP, RET, MARRIED, EMPLOYED
    }

}
