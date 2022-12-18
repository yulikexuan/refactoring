//: refactoring.catalog.api.domain.model.HeatingPlan


package refactoring.catalog.api.domain.model;


import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;

import javax.annotation.concurrent.ThreadSafe;


@Value
@ThreadSafe
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
class HeatingPlan implements IHeatingPlan {

    int max;

    int min;

    @Override
    public int targetTemperature(final int selectedTemperature) {

        if (selectedTemperature > max()) {
            return max;
        } else if (selectedTemperature < min()) {
            return min;
        } else {
            return selectedTemperature;
        }
    }

}///:~