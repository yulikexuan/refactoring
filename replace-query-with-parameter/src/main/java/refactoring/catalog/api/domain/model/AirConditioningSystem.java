//: refactoring.catalog.api.domain.model.AirConditioningSystem


package refactoring.catalog.api.domain.model;


import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;

import javax.annotation.concurrent.ThreadSafe;


@Value
@ThreadSafe
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
class AirConditioningSystem {

    Thermostat thermostat;

    IHeatingPlan heatingPlan;

    AirConditioningController controller;

    public void run() throws Exception {

        final int selectedTemp = thermostat.selectedTemperature();
        final int currentTemp = thermostat.currentTemperature();
        final int targetTemp = heatingPlan.targetTemperature(selectedTemp);

        if (targetTemp > currentTemp) {
            controller.setToHeat();
        } else if (targetTemp < currentTemp) {
            controller.setToCool();
        } else {
            controller.setOff();
        }
    }

}///:~