package refactoring.catalog.replace.primitive.domain.model;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import static org.mutabilitydetector.unittesting.MutabilityAssert.assertImmutable;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test Order Class - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class OrderTest {

    @Test
    void class_Order_Should_Be_Immutable() {

        assertImmutable(Order.class);
    }

}///:~