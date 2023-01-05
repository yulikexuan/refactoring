//: refactoring.catalog.inheritance.domain.model.init.Booking


package refactoring.catalog.inheritance.domain.model.init;


import static lombok.AccessLevel.*;
import static refactoring.catalog.inheritance.domain.model.OwningProperty.Property.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.Accessors;
import refactoring.catalog.inheritance.domain.model.Extras;
import refactoring.catalog.inheritance.domain.model.Show;

import java.time.DayOfWeek;
import java.time.LocalDate;


@Getter
@Accessors(fluent = true)
@AllArgsConstructor(access = PACKAGE)
public class Booking {

    final Show show;

    final LocalDate date;

    public boolean hasTalkback() {
        return this.show.hasOwnProperty(TALKBACK) && !this.isPeakDay();
    }

    public boolean isPeakDay() {
        return this.date.getDayOfWeek() == DayOfWeek.FRIDAY ||
                this.date.getDayOfWeek() == DayOfWeek.SATURDAY;
    }

    public long basePrice() {
        long price = this.show.price();
        if (this.isPeakDay()) {
            price = price + Math.round((double) price * 15 / 100);
        }
        return price;
    }

}

final class PremiumBooking extends Booking {

    private final Extras extras;

    private PremiumBooking(Show show, LocalDate date, Extras extras) {
        super(show, date);
        this.extras = extras;
    }

    static PremiumBooking of(@NonNull final Show show,
                             @NonNull final LocalDate date,
                             @NonNull final Extras extras) {

        return new PremiumBooking(show, date, extras);
    }

    public boolean hasTalkback() {
        return this.show.hasOwnProperty(TALKBACK);
    }

    public long basePrice() {
        return Math.round((double) (super.basePrice() + this.extras.premiumFee()));
    }

    public boolean hasDinner() {
        return this.extras.hasOwnProperty(DINNER) && !this.isPeakDay();
    }

}

///:~