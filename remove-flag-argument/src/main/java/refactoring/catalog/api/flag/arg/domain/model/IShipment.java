//: refactoring.catalog.api.flag.arg.domain.model.IShipment


package refactoring.catalog.api.flag.arg.domain.model;


import static refactoring.catalog.api.flag.arg.domain.model.State.*;

import java.time.LocalDate;
import java.util.List;


public interface IShipment {

    List<State> RUSH_DELIVERY_STATES = List.of(MA, CT);

    List<State> RUSH_DELIVERY_STATES_EXTRA = List.of(NY, NH);

    List<State> REGULAR_DELIVERY_STATES = List.of(MA, CT, NY);

    List<State> REGULAR_DELIVERY_STATES_EXTRA = List.of(ME, NH);

    LocalDate deliveryDate(Order order, boolean isRush);

    default LocalDate rushDelivery(Order order) {
        return deliveryDate(order, true);
    }

    default LocalDate regularDelivery(Order order) {
        return deliveryDate(order, false);
    }

}


final class ShipmentInit implements IShipment {

    /*
     * Here, the caller is using a literal boolean value to determine
     * which code should run
     *   — a classic flag argument
     *
     * But the whole point of using a Func is to follow the caller's instructions
     * so, it is better to clarify the caller's intent with explicit functions
     *
     */
    @Override
    public LocalDate deliveryDate(Order order, boolean isRush) {

        int deliveryDays = Integer.MAX_VALUE;

        if (isRush) {

            if (RUSH_DELIVERY_STATES.contains(order.deliveryState())) {
                deliveryDays = 1;
            } else if (RUSH_DELIVERY_STATES_EXTRA.contains(order.deliveryState())) {
                deliveryDays = 2;
            } else {
                deliveryDays = 3;
            }
            return order.placeOn().plusDays(2 + deliveryDays);
        } else {
            if (REGULAR_DELIVERY_STATES.contains(order.deliveryState())) {
                deliveryDays = 2;
            } else if (REGULAR_DELIVERY_STATES_EXTRA.contains(order.deliveryState())) {
                deliveryDays = 3;
            } else {
                deliveryDays = 4;
            }
            return order.placeOn().plusDays(2 + deliveryDays);
        }

    }

}

final class ShipmentRefactor implements IShipment {

    /*
     * This method is still useful if there are callers that use data for isRush
     * other than literal true or false
     */
    @Override
    public LocalDate deliveryDate(Order order, boolean isRush) {
        return isRush ? this.rushDelivery(order) : this.regularDelivery(order);
    }

    @Override
    public LocalDate rushDelivery(Order order) {

        int deliveryDays = Integer.MAX_VALUE;

        if (RUSH_DELIVERY_STATES.contains(order.deliveryState())) {
            deliveryDays = 1;
        } else if (RUSH_DELIVERY_STATES_EXTRA.contains(order.deliveryState())) {
            deliveryDays = 2;
        } else {
            deliveryDays = 3;
        }

        return order.placeOn().plusDays(2 + deliveryDays);
    }

    @Override
    public LocalDate regularDelivery(Order order) {

        int deliveryDays = Integer.MAX_VALUE;

        if (REGULAR_DELIVERY_STATES.contains(order.deliveryState())) {
            deliveryDays = 2;
        } else if (REGULAR_DELIVERY_STATES_EXTRA.contains(order.deliveryState())) {
            deliveryDays = 3;
        } else {
            deliveryDays = 4;
        }

        return order.placeOn().plusDays(2 + deliveryDays);
    }
}

///:~