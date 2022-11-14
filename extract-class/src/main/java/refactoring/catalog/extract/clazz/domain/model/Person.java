//: refactoring.catalog.extract.clazz.domain.model.Person


package refactoring.catalog.extract.clazz.domain.model;


import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.Accessors;


@Value
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
public class Person {

    static final String TELEPHONE_NUMBER_TEMPLATE = "%s1-%s2";

    @NonNull String name;

    @NonNull String officeAreaCode;

    @NonNull String officeNumber;

    public String officeTelephoneNumber() {
        return String.format(TELEPHONE_NUMBER_TEMPLATE,
                this.officeAreaCode, this.officeNumber);
    }

}///:~