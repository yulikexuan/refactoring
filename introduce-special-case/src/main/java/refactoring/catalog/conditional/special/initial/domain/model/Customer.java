//: refactoring.catalog.conditional.special.initial.domain.model.Customer


package refactoring.catalog.conditional.special.initial.domain.model;


import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;

import javax.annotation.concurrent.ThreadSafe;


@Value
@ThreadSafe
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
class Customer implements ICustomer {

    String name;

    BillingPlan billingPlan;

    IPaymentHistory paymentHistory;

}///:~