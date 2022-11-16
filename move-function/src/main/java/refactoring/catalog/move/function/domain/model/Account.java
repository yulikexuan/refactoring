//: refactoring.catalog.move.function.domain.model.Account


package refactoring.catalog.move.function.domain.model;


import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;


@Value
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
public class Account {

    static final long BASIC_CHARGE = 450;

    AccountType accountType;

    int daysOverdrawn;

    public long bankCharge() {
        return (this.daysOverdrawn > 0) ?
                BASIC_CHARGE + overdraftCharge() : BASIC_CHARGE;
    }

    private long overdraftCharge() {
        return this.accountType.calcOverdraftCharge(this.daysOverdrawn);
    }


}///:~