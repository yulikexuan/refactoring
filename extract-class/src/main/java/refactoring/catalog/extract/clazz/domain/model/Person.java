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

    @NonNull String name;

    @NonNull TelephoneNumber officeTelephoneNumber;

    public String officeTelephoneNumber() {
        return this.officeTelephoneNumber.toString();
    }

}///:~