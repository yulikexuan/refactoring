//: refactoring.catalog.inheritance.domain.model.PremiumBooking


package refactoring.catalog.inheritance.domain.model;


import lombok.NonNull;
import refactoring.catalog.inheritance.domain.model.refactor.BookingRefactor;

import java.time.LocalDate;


public interface PremiumBooking extends Booking {

    boolean hasDinner();

    static PremiumBooking of(@NonNull final Show show,
                             @NonNull final LocalDate date,
                             @NonNull final Extras extras) {

        return PremiumBookingDelegate.of(BookingRefactor.of(show, date), extras);
    }

}///:~