//: refactoring.catalog.conditional.flag.domain.service.ICandidateAlertService


package refactoring.catalog.conditional.flag.domain.service;


import lombok.NonNull;
import refactoring.catalog.conditional.flag.domain.model.IPerson;

import java.util.List;
import java.util.Optional;


public interface ICandidateAlertService {

    Optional<IPerson> checkForMiscreants(
            @NonNull List<IPerson> people,
            @NonNull String candidate1,
            @NonNull String candidate2);

}///:~