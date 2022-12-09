//: refactoring.catalog.conditional.flag.domain.service.CandidateAlertServiceRefactor


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
class CandidateAlertServiceRefactor implements ICandidateAlertService {

    private final Alert alert;

    @Override
    public Optional<IPerson> checkForMiscreants(
            @NonNull List<IPerson> people,
            @NonNull String candidate1,
            @NonNull String candidate2) {

        return people.stream()
                .filter(p -> candidate1.equals(p.name()) || candidate2.equals(p.name()))
                .map(p -> {
                    alert.sendAlert(p.name());
                    return p;
                }).findFirst();
    }

}///:~