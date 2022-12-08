//: refactoring.catalog.conditional.special.initial.domain.model.ICustomer


package refactoring.catalog.conditional.special.initial.domain.model;


import lombok.NonNull;

public interface ICustomer {

    String UNKNOWN_CUSTOMER_NAME = "unknown";

    String OCCUPANT_CUSTOMER_NAME = "occupant";

    String name();

    BillingPlan billingPlan();

    IPaymentHistory paymentHistory();

    static ICustomer of(@NonNull final String name,
                        @NonNull final BillingPlan billingPlan,
                        @NonNull final IPaymentHistory paymentHistory) {

        return Customer.of(name, billingPlan, paymentHistory);
    }

    static ICustomer newUnknownCustomer(
            @NonNull final BillingPlan billingPlan,
            @NonNull final IPaymentHistory paymentHistory) {

        return Customer.of(UNKNOWN_CUSTOMER_NAME, billingPlan, paymentHistory);
    }

    static ICustomer withNewBillingPlan(@NonNull final ICustomer customer,
                                        @NonNull final BillingPlan newBillingPlan) {

        return of(customer.name(), newBillingPlan, customer.paymentHistory());
    }

}///:~