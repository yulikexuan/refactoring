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

        // When
        this.person = Person.of(personName);
        this.person.courses(this.courses);

        // Then
        assertThat(this.courses).isNotSameAs(this.person.courses());
        assertThat(this.courses).containsExactlyElementsOf(this.person.courses());
        assertThat(this.person.numberOfAdvancedCourses()).isEqualTo(2);

        // When
        this.person.addCourse(newCourse);

        // Then
        assertThat(this.person.name()).isEqualTo(personName);
        assertThat(this.person.courses().get(initialCourseSize).name())
                .isEqualTo(newCourseName);
        assertThat(this.person.courses().size())
                .isEqualTo(initialCourseSize + 1);

        // When
        boolean removed = this.person.removeCourse(newCourse);

        // Then
        assertThat(removed).isTrue();
        assertThat(this.person.courses().size()).isEqualTo(initialCourseSize);
    }

    @Test
    void able_To_Assign_Basic_Courses_To_Person() {

        // Given
        String personName = RandomStringUtils.randomAlphabetic(7);

        List<String> basicCourseNames = List.of(
                RandomStringUtils.randomAlphanumeric(7),
                RandomStringUtils.randomAlphanumeric(7),
                RandomStringUtils.randomAlphanumeric(7));

        this.person = Person.of(personName);
        this.person.courses(this.courses);

        // When
        this.person.assignBasicCourses(basicCourseNames);

        // Then
        assertThat(this.person.numberOfCourses()).isEqualTo(
                this.courses.size() + basicCourseNames.size());

        long added = basicCourseNames.stream().filter(n -> person.contains(n))
                .count();

        assertThat(added).isEqualTo(basicCourseNames.size());
    }

}///:~