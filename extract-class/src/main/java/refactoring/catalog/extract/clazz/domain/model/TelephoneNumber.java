//: refactoring.catalog.extract.clazz.domain.model.TelephoneNumber


package refactoring.catalog.extract.clazz.domain.model;


import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;


@Value
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
public class TelephoneNumber {

    static final String TELEPHONE_NUMBER_TEMPLATE = "%s-%s";

    String areaCode;

    String number;

    public String toString() {
        return String.format(TELEPHONE_NUMBER_TEMPLATE, areaCode, number);
    }

}///:~