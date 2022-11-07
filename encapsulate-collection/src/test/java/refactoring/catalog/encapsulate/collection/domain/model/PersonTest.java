package refactoring.catalog.encapsulate.collection.domain.model;


import com.google.common.collect.Lists;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test Person Class - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class PersonTest {

    private List<Course> courses;

    private Person person;

    @BeforeEach
    void setUp() {
        courses = Lists.newArrayList(
                Course.of(RandomStringUtils.randomAlphanumeric(7),
                        true),
                Course.of(RandomStringUtils.randomAlphanumeric(7),
                        false),
                Course.of(RandomStringUtils.randomAlphanumeric(7),
                        true));
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void able_To_Change_Elements_Of_Courses_Of_Person(boolean isAdvanced) {

        // Given
        String personName = RandomStringUtils.randomAlphabetic(7);
        String newCourseName = RandomStringUtils.randomAlphabetic(7);

        Course newCourse = Course.of(newCourseName, isAdvanced);

        int initialCourseSize = this.courses.size();

        this.person = Person.of(personName);
        this.person.courses(this.courses);

        // When
        this.person.courses().add(newCourse);

        // Then
        assertThat(this.person.name()).isEqualTo(personName);
        assertThat(this.person.courses().get(initialCourseSize).name())
                .isEqualTo(newCourseName);
        assertThat(this.person.courses().size())
                .isEqualTo(initialCourseSize + 1);

        // When
        this.person.courses().remove(newCourse);

        // Then
        assertThat(this.person.courses().size()).isEqualTo(initialCourseSize);
    }

}///:~