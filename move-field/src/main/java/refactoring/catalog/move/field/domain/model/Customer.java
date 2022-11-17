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

    @NonNull CustomerContract contract;

    public static Customer newCustomer(
            @NonNull final String name, final int discountRate) {

        return Customer.of(name, CustomerContract.newContract(discountRate));
    }

    public static Customer becomePreferred(@NonNull final Customer customer) {

        CustomerContract newContract = CustomerContract.applyNewDiscountRate(
                customer.contract, customer.contract.discountRate() + 3);

        return Customer.of(customer.name, newContract);
    }

    public long applyDiscount(final long amount) {
        return amount - amount * this.contract.discountRate() / 100;
    }

    public int discountRate() {
        return this.contract.discountRate();
    }

}///:~