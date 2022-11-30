//: refactoring.catalog.change.reference.domain.refactor.service.TelephoneNumberChangeService


package refactoring.catalog.change.reference.domain.refactor.service;


import lombok.NonNull;
import refactoring.catalog.change.reference.domain.refactor.model.Person;


class TelephoneNumberChangeService {

    void changeAreaNumber(@NonNull final Person person,
                          @NonNull final String newAreaNumber) {

        person.officeNumber(newAreaNumber);
    }

}///:~