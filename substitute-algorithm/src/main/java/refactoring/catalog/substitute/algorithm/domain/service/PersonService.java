//: refactoring.catalog.substitute.algorithm.domain.service.PersonService


package refactoring.catalog.substitute.algorithm.domain.service;


import lombok.NonNull;
import refactoring.catalog.substitute.algorithm.domain.model.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class PersonService {

    static final List<String> CANDIDATE = List.of("Don", "John", "Kent");

    Optional<Person> findCandidate(@NonNull final Person[] people) {

        return Arrays.stream(people)
                .filter(this::isCandidate)
                .findFirst();
    }

    private boolean isCandidate(@NonNull final Person person) {
        return CANDIDATE.contains(person.name());
    }

}///:~