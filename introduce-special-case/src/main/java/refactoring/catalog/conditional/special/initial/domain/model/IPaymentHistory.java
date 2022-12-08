//: refactoring.catalog.conditional.special.initial.domain.model.IPaymentHistory


package refactoring.catalog.conditional.special.initial.domain.model;


import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;

import javax.annotation.concurrent.ThreadSafe;

public interface IPaymentHistory {

    int weeksDelinquentInLastYear();

}

@Value
@ThreadSafe
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
final class PaymentHistory implements IPaymentHistory {

    int weeksDelinquentInLastYear;

}///:~