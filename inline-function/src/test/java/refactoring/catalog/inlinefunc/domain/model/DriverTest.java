package refactoring.catalog.inlinefunc.domain.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import static org.mutabilitydetector.unittesting.MutabilityAssert.assertInstancesOf;
import static org.mutabilitydetector.unittesting.MutabilityMatchers.areImmutable;


@DisplayName("Test StatementService - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class DriverTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void class_Driver_Should_Be_Immutable() {
        assertInstancesOf(Driver.class, areImmutable());
    }

}