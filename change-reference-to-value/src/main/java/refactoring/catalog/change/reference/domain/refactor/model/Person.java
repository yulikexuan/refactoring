//: refactoring.catalog.change.reference.domain.refactor.model.Person


package refactoring.catalog.change.reference.domain.refactor.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.annotation.concurrent.ThreadSafe;


@Data
@ThreadSafe
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
public class Person {

    String name;

    TelephoneNumber telephoneNumber;

    public String officeAreaCode() {
        return this.telephoneNumber.officeAreaCode();
    }

    public void officeAreaCode(String officeAreaCode) {
        this.telephoneNumber = TelephoneNumber.of(
                officeAreaCode, this.telephoneNumber.officeNumber());
    }

    public String officeNumber() {
        return this.telephoneNumber.officeNumber();
    }

    public void officeNumber(String officeNumber) {
        this.telephoneNumber = TelephoneNumber.of(
                this.telephoneNumber.officeAreaCode(), officeNumber);
    }

}///:~