//: refactoring.catalog.inheritance.domain.model.PremiumBookingDelegate


package refactoring.catalog.inheritance.domain.model;


import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;
import refactoring.catalog.inheritance.domain.model.refactor.BookingRefactor;

import static refactoring.catalog.inheritance.domain.model.OwningProperty.Property.DINNER;


@Value
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
public class PremiumBookingDelegate implements PremiumBooking {

    private final BookingRefactor host;

    private final Extras extras;

    @Override
    public boolean hasTalkback() {
        return this.host.isTalkbackShow();
    }

    @Override
    public boolean isPeakDay() {
        return this.host.isPeakDay();
    }

    @Override
    public long basePrice() {
        return Math.round((double) (host.basePrice() + this.extras.premiumFee()));
    }

    @Override
    public boolean hasDinner() {
        return this.extras.hasOwnProperty(DINNER) && !this.host.isPeakDay();
    }

    @Override
    public boolean isTalkbackShow() {
        return this.host.isTalkbackShow();
    }

}///:~