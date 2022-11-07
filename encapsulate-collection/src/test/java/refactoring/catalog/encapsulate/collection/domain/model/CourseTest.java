package refactoring.catalog.encapsulate.collection.domain.model;


import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import static org.mutabilitydetector.unittesting.MutabilityAssert.assertImmutable;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test Course Class - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class CourseTest {

    @Test
    void class_Course_Should_Be_Immutable() {
        assertImmutable(CourseImpl.class);
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void has_Fluent_Accessors(boolean isAdvanced) {

        // Given
        String name = RandomStringUtils.randomAlphanumeric(7);

        // When
        Course courseImpl = CourseImpl.of(name, isAdvanced);

        // Then
        assertThat(courseImpl.name()).isEqualTo(name);
        assertThat(courseImpl.isAdvanced()).isEqualTo(isAdvanced);
    }

}///:~