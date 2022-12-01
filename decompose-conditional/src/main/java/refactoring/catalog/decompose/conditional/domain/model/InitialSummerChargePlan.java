//: refactoring.catalog.decompose.conditional.domain.model.ChargePlan


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
class InitialSummerChargePlan implements ISummerChargePlan {

    @NonNull
    private final IChargePlan chargePlan;

    @NonNull
    LocalDate summerStart;

    @NonNull
    LocalDate summerEnd;

    long summerRate;

    @Override
    public long charge(final long quantity, @NonNull final LocalDate aDate) {

        long charge = Long.MAX_VALUE;

        if (!aDate.isBefore(summerStart) && !aDate.isAfter(summerEnd)) {
            charge = quantity * summerRate / 100;
        } else {
            charge = quantity * this.chargePlan.regularRate() / 100 +
                    this.chargePlan.regularServiceCharge();
        }

        return charge;
    }

}///:~