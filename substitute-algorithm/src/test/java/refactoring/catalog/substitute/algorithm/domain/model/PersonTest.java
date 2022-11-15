package refactoring.catalog.substitute.algorithm.domain.model;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import static org.mutabilitydetector.unittesting.MutabilityAssert.assertImmutable;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test class Person - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class PersonTest {

    @Test
    void class_Person_Should_Be_Immutable() {
        assertImmutable(Person.class);
    }

}///:~