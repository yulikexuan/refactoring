//: refactoring.catalog.conditional.special.refactor.domain.model.SiteRefactor


package refactoring.catalog.conditional.special.refactor.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.Accessors;
import refactoring.catalog.conditional.special.initial.domain.model.BillingPlan;
import refactoring.catalog.conditional.special.initial.domain.model.ICustomer;


@Data
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
class SiteRefactor {

    @NonNull
    ICustomerRefactor customer;

    public String displayName() {
        return this.customer.displayName();
    }

    public BillingPlan displayBillingPlan() {
        return customer.billingPlan();
    }

    public void updateBillingPlan(@NonNull final BillingPlan billingPlan) {
        customer = this.customer.newBillingPlan(billingPlan);
    }

    public BillingPlan customerBillingPlan() {
        return this.customer.billingPlan();
    }

    public int displayWeeksDelinquent() {
        return customer.weeksDelinquent();
    }

}///:~