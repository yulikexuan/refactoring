//: refactoring.catalog.change.reference.domain.initial.model.Person


package refactoring.catalog.change.reference.domain.initial.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
public class Person {

    private String name;

    private TelephoneNumber telephoneNumber;

    public String officeAreaCode() {
        return this.telephoneNumber.officeAreaCode();
    }

    public void officeAreaCode(String officeAreaCode) {
        this.telephoneNumber.officeAreaCode(officeAreaCode);
    }

    public String officeNumber() {
        return this.telephoneNumber.officeNumber();
    }

    public void officeNumber(String officeNumber) {
        this.telephoneNumber.officeNumber(officeNumber);
    }

}///:~