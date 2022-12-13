//: refactoring.catalog.api.flag.arg.tangle.domain.model.ITangleShipment


package refactoring.catalog.api.flag.arg.tangle.domain.model;


import static refactoring.catalog.api.flag.arg.domain.model.State.*;

import lombok.NonNull;
import refactoring.catalog.api.flag.arg.domain.model.Order;
import refactoring.catalog.api.flag.arg.domain.model.State;

import java.time.LocalDate;


public interface ITangleShipment {

    LocalDate deliveryDate(Order order, boolean isRush);

}


final class TangleShipmentInit implements ITangleShipment {

    /*
     * In this case, teasing out isRush into a top-level dispatch conditional
     * is likely more work than we fancy
     *
     * So instead, I can layer functions over the deliveryDate:
     *   - rushDeliveryDate(Order)
     *   - regularDeliveryDate(Order)
     */
    @Override
    public LocalDate deliveryDate(@NonNull final Order order,
                                  final boolean isRush) {

        LocalDate deliveryDate = null;

        int deliveryDays = Integer.MAX_VALUE;

        final State deliveryState = order.deliveryState();

        if ((deliveryState == MA) || (deliveryState == CT)) {
            deliveryDays = isRush ? 1 : 2;
        } else if ((deliveryState == NY) || (deliveryState == NH)) {
            deliveryDays = 2;
            if ((deliveryState == NH) && !isRush) {
                deliveryDays = 3;
            }
        } else if (isRush) {
            deliveryDays = 3;
        } else if (deliveryState == ME) {
            deliveryDays = 3;
        } else {
            deliveryDays = 4;
        }

        deliveryDate = order.placeOn().plusDays(2 + deliveryDays);

        if (isRush) {
            deliveryDate = deliveryDate.minusDays(1);
        }

        return deliveryDate;
    }

    public LocalDate rushDeliveryDate(@NonNull final Order order) {
        return deliveryDate(order, true);
    }

    public LocalDate regularDeliveryDate(@NonNull final Order order) {
        return deliveryDate(order, false);
    }

}

///:~