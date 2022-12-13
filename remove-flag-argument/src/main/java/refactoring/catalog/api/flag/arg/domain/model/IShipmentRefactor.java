//: refactoring.catalog.api.flag.arg.domain.model.IShipmentRefactor


package refactoring.catalog.api.flag.arg.domain.model;


import lombok.NonNull;

import static refactoring.catalog.api.flag.arg.domain.model.IShipment.*;

import java.time.LocalDate;


public interface IShipmentRefactor {

    LocalDate rushDelivery(Order order);

    LocalDate regularDelivery(Order order);

}

final class ShipmentFinal implements IShipmentRefactor {

    @Override
    public LocalDate rushDelivery(Order order) {

        if (RUSH_DELIVERY_STATES.contains(order.deliveryState()))
            return calcDeliveryDate(order, 1);

        if (RUSH_DELIVERY_STATES_EXTRA.contains(order.deliveryState()))
            return calcDeliveryDate(order, 2);

        return calcDeliveryDate(order, 3);
    }

    @Override
    public LocalDate regularDelivery(Order order) {

        if (REGULAR_DELIVERY_STATES.contains(order.deliveryState()))
            return calcDeliveryDate(order, 2);

        if (REGULAR_DELIVERY_STATES_EXTRA.contains(order.deliveryState()))
            return calcDeliveryDate(order, 3);

        return calcDeliveryDate(order, 4);
    }

    private LocalDate calcDeliveryDate(
            @NonNull final Order order, final int deliveryDays) {

        return order.placeOn().plusDays(2 + deliveryDays);
    }

}

///:~