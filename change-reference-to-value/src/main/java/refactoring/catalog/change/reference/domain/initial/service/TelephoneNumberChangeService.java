//: refactoring.catalog.change.reference.domain.initial.service.TelephoneNumberChangeService


package refactoring.catalog.change.reference.domain.initial.service;


import lombok.NonNull;
import refactoring.catalog.change.reference.domain.initial.model.Person;


public class TelephoneNumberChangeService {

    void changeTelephoneNumber(@NonNull final Person person,
                               @NonNull final String newNumber) {

        person.officeNumber(newNumber);
    }

}///:~