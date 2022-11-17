//: refactoring.catalog.move.field.domain.model.CustomerContract


package refactoring.catalog.move.field.domain.model;


import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.Accessors;

import java.time.LocalDate;


@Value
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
public class CustomerContract {

    @NonNull int discountRate;
    @NonNull LocalDate startDate;

    public static CustomerContract newContract(final int discountRate) {
        return CustomerContract.of(discountRate, LocalDate.now());
    }

    public static CustomerContract applyNewDiscountRate(
            @NonNull final CustomerContract customerContract, final int discountRate) {

        return CustomerContract.of(discountRate, customerContract.startDate);
    }

}///:~