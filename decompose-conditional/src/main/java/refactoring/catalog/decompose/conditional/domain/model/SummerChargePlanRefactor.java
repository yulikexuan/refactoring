//: refactoring.catalog.decompose.conditional.domain.model.NewSummerChargePlan


package refactoring.catalog.decompose.conditional.domain.model;


import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.Accessors;

import javax.annotation.concurrent.ThreadSafe;
import java.time.LocalDate;


@Value
@ThreadSafe
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
class SummerChargePlanRefactor implements ISummerChargePlan {

    private final IChargePlan chargePlan;

    @NonNull
    LocalDate summerStart;

    @NonNull
    LocalDate summerEnd;

    long summerRate;

    @Override
    public long charge(final long quantity, @NonNull final LocalDate aDate) {
        return isInSummer(aDate) ? summerCharge(quantity) :
                IChargePlan.regularCharge(quantity, chargePlan);
    }

    boolean isInSummer(@NonNull final LocalDate aDate) {
        return !aDate.isBefore(summerStart) && !aDate.isAfter(summerEnd);
    }

    long summerCharge(final long quantity) {
        return quantity * summerRate / 100;
    }

}///:~