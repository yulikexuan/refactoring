//: refactoring.catalog.move.field.domain.model.Customer


package refactoring.catalog.move.field.domain.model;


import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.Accessors;


@Value
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
public class Customer {

    @NonNull String name;

    @NonNull int discountRate;

    @NonNull CustomerContract contract;

    public static Customer newCustomer(
            @NonNull final String name, final int discountRate) {

        return Customer.of(name, discountRate, CustomerContract.newContract());
    }

    public static Customer becomePreferred(@NonNull final Customer customer) {
        return Customer.of(customer.name, customer.discountRate + 3,
                customer.contract);
    }

    public long applyDiscount(final long amount) {
        return amount - amount * this.discountRate / 100;
    }

}///:~