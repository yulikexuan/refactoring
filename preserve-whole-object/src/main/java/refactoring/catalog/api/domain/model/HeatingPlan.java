//: refactoring.catalog.api.domain.model.HeatingPlan


package refactoring.catalog.api.domain.model;


import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.Accessors;

import javax.annotation.concurrent.ThreadSafe;


public interface HeatingPlan {

    TempRange temperatureRange();

    default boolean withinRange(final long bottom, final long top) {

        return (bottom >= this.temperatureRange().low()) &&
                (top <= this.temperatureRange().high());
    }

    default boolean withInRange(@NonNull final TempRange tempRange) {
        throw new IllegalCallerException();
    }

    static HeatingPlan initPlan(TempRange tempRange) {
        return HeatingPlanInit.of(tempRange);
    }

    static HeatingPlan refactorPlan(TempRange tempRange) {
        return HeatingPlanRefactor.of(tempRange);
    }

}

@Value
@ThreadSafe
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
final class HeatingPlanInit implements HeatingPlan {

    private final TempRange temperatureRange;

}

@Value
@ThreadSafe
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
final class HeatingPlanRefactor implements HeatingPlan {

    private final TempRange temperatureRange;

    @Override
    public boolean withInRange(@NonNull TempRange roomTempRange) {
        return withinRange(roomTempRange.low(), roomTempRange.high());
    }
}

///:~