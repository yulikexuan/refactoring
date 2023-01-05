//: refactoring.catalog.inheritance.domain.model.refactor.Booking


package refactoring.catalog.inheritance.domain.model;


import lombok.NonNull;
import refactoring.catalog.inheritance.domain.model.refactor.BookingRefactor;

import java.time.LocalDate;


public interface Booking {

    boolean hasTalkback();

    boolean isPeakDay();

    long basePrice();

    boolean isTalkbackShow();

    default PremiumBooking beingPremium(Extras extras) {
        throw new UnsupportedOperationException();
    }

    public static BookingRefactor of(@NonNull final Show show,
                                     @NonNull final LocalDate date) {

        return BookingRefactor.of(show, date);
    }

}///:~