package refactoring.catalog.extractvar.domain.model;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import static org.mutabilitydetector.unittesting.MutabilityAssert.assertInstancesOf;
import static org.mutabilitydetector.unittesting.MutabilityMatchers.areImmutable;


@DisplayName("Test StatementService - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class OrderTest {

    @Test
    void class_Order_Should_Be_Immutable() {
        assertInstancesOf(Order.class, areImmutable());
    }

}