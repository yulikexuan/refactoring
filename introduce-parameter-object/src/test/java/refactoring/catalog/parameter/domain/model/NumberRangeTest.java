package refactoring.catalog.parameter.domain.model;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import static org.mutabilitydetector.unittesting.MutabilityAssert.assertImmutable;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test StatementService - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class NumberRangeTest {

    @Test
    void class_NumberRange_Should_Be_Immutable() {
        assertImmutable(NumberRange.class);
    }

    @ParameterizedTest
    @CsvSource({"1, 1", "3, 1", "10, 9"})
    void min_Should_Be_Less_Than_Max(int min, int max) {
        assertThatThrownBy(() -> NumberRange.of(min, max))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("min should be less than max");
    }

}