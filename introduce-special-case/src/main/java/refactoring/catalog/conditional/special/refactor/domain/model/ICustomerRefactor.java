//: refactoring.catalog.conditional.special.refactor.domain.model.ICustomer


package refactoring.catalog.conditional.special.refactor.domain.model;


import static refactoring.catalog.conditional.special.initial.domain.model.BillingPlan.*;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.Accessors;
import refactoring.catalog.conditional.special.initial.domain.model.BillingPlan;
import refactoring.catalog.conditional.special.initial.domain.model.IPaymentHistory;

import javax.annotation.concurrent.ThreadSafe;


public interface ICustomerRefactor {

    String UNKNOWN_CUSTOMER_NAME = "unknown";

    String OCCUPANT_CUSTOMER_NAME = "occupant";

    String name();

    BillingPlan billingPlan();

    IPaymentHistory paymentHistory();

    default String displayName() {
        return name();
    }

    default ICustomerRefactor newBillingPlan(
            @NonNull final BillingPlan newBillingPlan) {

        return ICustomerRefactor.of(
                this.name(), newBillingPlan, this.paymentHistory());
    }

    default int weeksDelinquent() {
        return this.paymentHistory().weeksDelinquentInLastYear();
    }

    static ICustomerRefactor of(@NonNull final String name,
                        @NonNull final BillingPlan billingPlan,
                        @NonNull final IPaymentHistory paymentHistory) {

        return (UNKNOWN_CUSTOMER_NAME.equals(name)) ?
                UnknownCustomer.of(name, BASIC, paymentHistory) :
                CustomerRefactor.of(name, billingPlan, paymentHistory);
    }

}

@Value
@ThreadSafe
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
class CustomerRefactor implements ICustomerRefactor {

    String name;

    BillingPlan billingPlan;

    IPaymentHistory paymentHistory;

}

@Value
@ThreadSafe
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
class UnknownCustomer implements ICustomerRefactor {

    String name;

    BillingPlan billingPlan;

    IPaymentHistory paymentHistory;

    @Override
    public String displayName() {
        return OCCUPANT_CUSTOMER_NAME;
    }

    @Override
    public ICustomerRefactor newBillingPlan(
            @NonNull final BillingPlan newBillingPlan) {

        return this;
    }

    @Override
    public  int weeksDelinquent() {
        return 0;
    }

}

///:~