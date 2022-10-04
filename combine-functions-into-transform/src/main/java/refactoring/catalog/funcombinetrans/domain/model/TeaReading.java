//: refactoring.catalog.funcombine.domain.model.TeaReading


package refactoring.catalog.funcombinetrans.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@Data
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class TeaReading {

    private String customer;

    private int quantity;

    private int month;

    private int year;

}///:~