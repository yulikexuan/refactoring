//: refactoring.catalog.inheritance.domain.model.refactor.BookingRefactor


package refactoring.catalog.inheritance.domain.model.refactor;


import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.Accessors;
import refactoring.catalog.inheritance.domain.model.*;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static refactoring.catalog.inheritance.domain.model.OwningProperty.Property.TALKBACK;


@Value
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
public class BookingRefactor implements Booking {

    final Show show;

    final LocalDate date;

    @Override
    public boolean hasTalkback() {
        return isTalkbackShow() && !this.isPeakDay();
    }

    @Override
    public boolean isTalkbackShow() {
        return this.show.hasOwnProperty(TALKBACK);
    }

    @Override
    public boolean isPeakDay() {
        return this.date.getDayOfWeek() == DayOfWeek.FRIDAY ||
                this.date.getDayOfWeek() == DayOfWeek.SATURDAY;
    }

    @Override
    public long basePrice() {
        long price = this.show.price();
        if (this.isPeakDay()) {
            price = price + Math.round((double) price * 15 / 100);
        }
        return price;
    }

    @Override
    public PremiumBooking beingPremium(@NonNull final Extras extras) {

        return PremiumBookingDelegate.of(this, extras);
    }

}


//final class PremiumBookingRefactor extends BookingRefactor implements PremiumBooking {
//
//    private final Extras extras;
//
//    private PremiumBookingRefactor(Show show, LocalDate date, Extras extras) {
//        super(show, date);
//        this.extras = extras;
//    }
//
//    static PremiumBookingRefactor of(@NonNull final Show show,
//                                     @NonNull final LocalDate date,
//                                     @NonNull final Extras extras) {
//
//        return new PremiumBookingRefactor(show, date, extras);
//    }
//
//    @Override
//    public boolean hasTalkback() {
//        return this.show.hasOwnProperty(TALKBACK);
//    }
//
//    @Override
//    public long basePrice() {
//        return Math.round((double) (super.basePrice() + this.extras.premiumFee()));
//    }
//
//    @Override
//    public boolean hasDinner() {
//        return this.extras.hasOwnProperty(DINNER) && !this.isPeakDay();
//    }
//
//}

///:~