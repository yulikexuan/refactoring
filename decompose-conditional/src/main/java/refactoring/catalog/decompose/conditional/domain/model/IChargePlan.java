//: refactoring.catalog.decompose.conditional.domain.model.IChargePlan


package refactoring.catalog.decompose.conditional.domain.model;


import lombok.NonNull;


public interface IChargePlan {

    long regularRate();

    long regularServiceCharge();

    static long regularCharge(final long quantity,
                              @NonNull final IChargePlan regularPlan) {

        return quantity * regularPlan.regularRate() / 100 +
                regularPlan.regularServiceCharge();
    }

}///:~