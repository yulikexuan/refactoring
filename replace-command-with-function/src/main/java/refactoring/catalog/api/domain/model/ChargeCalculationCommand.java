//: refactoring.catalog.api.domain.model.ChargeCalculationCommand


package refactoring.catalog.api.domain.model;


import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;


@Accessors(fluent = true)
@RequiredArgsConstructor(staticName = "of")
public class ChargeCalculationCommand {

    private final Customer customer;

    private final Usage usage;

    private final Provider provider;

    long baseCharge() {
        return this.customer.baseRate() * this.usage.amount() / 100;
    }

    public long execute() {

        // return baseCharge() + this.provider.connectionCharge();

        long baseCharge = this.customer.baseRate() * this.usage.amount() / 100;
        return baseCharge + this.provider.connectionCharge();
    }

}///:~