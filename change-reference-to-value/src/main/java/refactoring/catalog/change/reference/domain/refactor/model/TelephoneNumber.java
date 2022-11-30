//: refactoring.catalog.change.reference.domain.refactor.model.TelephoneNumber


package refactoring.catalog.change.reference.domain.refactor.model;


import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;

import javax.annotation.concurrent.ThreadSafe;


@Value
@ThreadSafe
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
public class TelephoneNumber {

    String officeAreaCode;

    String officeNumber;

}///:~