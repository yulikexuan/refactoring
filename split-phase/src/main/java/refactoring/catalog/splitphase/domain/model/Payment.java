//: refactoring.catalog.splitphase.domain.model.Payment


package refactoring.catalog.splitphase.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@Data
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class Payment {

    public enum Status {
        READY, PAID;
    }

    int price;

    Status status;

}///:~