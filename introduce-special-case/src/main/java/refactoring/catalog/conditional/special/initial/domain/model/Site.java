//: refactoring.catalog.conditional.special.initial.domain.model.Site


package refactoring.catalog.conditional.special.initial.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.Accessors;


@Data
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
public class Site {

    @NonNull
    ICustomer customer;

    public String displayName() {

        final String customerName = customer.name();

        return (ICustomer.UNKNOWN_CUSTOMER_NAME.equals(customerName)) ?
                ICustomer.OCCUPANT_CUSTOMER_NAME : customerName;
    }

    public BillingPlan displayBillingPlan() {

        final String customerName = customer.name();

        return ICustomer.UNKNOWN_CUSTOMER_NAME.equals(customerName) ?
                BillingPlan.BASIC : customer.billingPlan();
    }

    public void updateBillingPlan(@NonNull final BillingPlan billingPlan) {

        if (!ICustomer.UNKNOWN_CUSTOMER_NAME.equals(customer.name())) {
            customer = ICustomer.withNewBillingPlan(customer, billingPlan);
        }
    }

    public BillingPlan customerBillingPlan() {
        return this.customer.billingPlan();
    }

    public int displayWeeksDelinquent() {

        final String customerName = customer.name();

        return ICustomer.UNKNOWN_CUSTOMER_NAME.equals(customerName) ?
                0 : customer.paymentHistory().weeksDelinquentInLastYear();
    }


}///:~