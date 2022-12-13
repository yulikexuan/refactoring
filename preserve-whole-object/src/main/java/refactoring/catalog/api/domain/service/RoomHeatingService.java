//: refactoring.catalog.api.domain.service.RoomHeatingService


package refactoring.catalog.api.domain.service;


import lombok.AllArgsConstructor;
import lombok.NonNull;
import refactoring.catalog.api.domain.model.HeatingAlert;
import refactoring.catalog.api.domain.model.HeatingCommand;
import refactoring.catalog.api.domain.model.HeatingPlan;
import refactoring.catalog.api.domain.model.Room;

import javax.annotation.concurrent.ThreadSafe;


@ThreadSafe
@AllArgsConstructor(staticName = "of")
class RoomHeatingService {

    private final HeatingPlan heatingPlan;

    private final HeatingCommand heatingCommand;

    private final HeatingAlert heatingAlert;

    public void heating(@NonNull final Room room) {

        long low = room.daysTempRange().low();
        long high = room.daysTempRange().high();

        if (heatingPlan.withInRange(room.daysTempRange())) {
            this.heatingCommand.executeHeating();
        } else {
            heatingAlert.alert(room);
        }
    }

}///:~