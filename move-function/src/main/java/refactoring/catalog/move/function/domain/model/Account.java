//: refactoring.catalog.move.function.domain.model.Account


package refactoring.catalog.move.function.domain.model;


import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;


@Value
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
public class Account {

    static final int BASE_OVERDRAWN_DAYS = 7;

    static final long BASIC_CHARGE = 450;

    static final long BASE_OVERDRAWN_CHARGE = 1000;

    AccountType accountType;

    int daysOverdrawn;

    public long bankCharge() {

        if (this.daysOverdrawn > 0) {
            return BASIC_CHARGE + this.overdraftCharge();
        }

        return BASIC_CHARGE;
    }

    long overdraftCharge() {

        if (this.accountType == AccountType.PREMIUM) {

            if (this.daysOverdrawn <= BASE_OVERDRAWN_DAYS) {
                return BASE_OVERDRAWN_CHARGE;
            } else {
                return BASE_OVERDRAWN_CHARGE +
                        (this.daysOverdrawn - BASE_OVERDRAWN_DAYS) * 85;
            }
        } else {
            return this.daysOverdrawn * 175;
        }
    }

}///:~