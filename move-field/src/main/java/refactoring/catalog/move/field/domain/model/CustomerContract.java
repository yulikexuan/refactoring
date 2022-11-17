//: refactoring.catalog.move.field.domain.model.CustomerContract


package refactoring.catalog.move.field.domain.model;


import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;

import java.time.LocalDate;


@Value
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
public class CustomerContract {

    LocalDate localDate;

    public static CustomerContract newContract() {
        return CustomerContract.of(LocalDate.now());
    }

}///:~