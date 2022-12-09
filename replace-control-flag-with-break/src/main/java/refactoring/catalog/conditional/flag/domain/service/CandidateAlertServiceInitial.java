//: refactoring.catalog.conditional.flag.domain.service.CandidateAlertService


package refactoring.catalog.conditional.flag.domain.service;


import lombok.AllArgsConstructor;
import lombok.NonNull;
import refactoring.catalog.conditional.flag.domain.model.Alert;
import refactoring.catalog.conditional.flag.domain.model.IPerson;

import javax.annotation.concurrent.ThreadSafe;
import java.util.List;
import java.util.Optional;


@ThreadSafe
@AllArgsConstructor(staticName = "of")
public class CandidateAlertServiceInitial implements ICandidateAlertService {

    private final Alert alert;

    @Override
    public Optional<IPerson> checkForMiscreants(
            @NonNull final List<IPerson> people,
            @NonNull final String candidate1,
            @NonNull final String candidate2) {

        boolean found = false;
        IPerson miscreant = null;

        for (IPerson person : people) {
            if (!found) {
                if (candidate1.equals(person.name())) {
                    this.alert.sendAlert(candidate1);
                    found = true;
                    miscreant = person;
                }
                if (candidate2.equals(person.name())) {
                    this.alert.sendAlert(candidate2);
                    found = true;
                    miscreant = person;
                }
            }
        }

        return Optional.ofNullable(miscreant);
    }

}///:~