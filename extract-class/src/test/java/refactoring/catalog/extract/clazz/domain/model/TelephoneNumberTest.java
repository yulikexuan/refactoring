package refactoring.catalog.extract.clazz.domain.model;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import static org.mutabilitydetector.unittesting.MutabilityAssert.assertImmutable;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test TelephoneNumber Class - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class TelephoneNumberTest {

    @Test
    void class_TelephoneNumber_Should_Be_Immutable() {
        assertImmutable(TelephoneNumber.class);
    }

}///:~