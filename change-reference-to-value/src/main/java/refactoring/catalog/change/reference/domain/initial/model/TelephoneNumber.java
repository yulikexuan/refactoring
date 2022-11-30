//: refactoring.catalog.change.reference.domain.initial.model.TelephoneNumber


package refactoring.catalog.change.reference.domain.initial.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
public class TelephoneNumber {

    private String officeAreaCode;

    private String officeNumber;

}///:~