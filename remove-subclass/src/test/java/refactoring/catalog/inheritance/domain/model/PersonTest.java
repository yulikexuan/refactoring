package refactoring.catalog.inheritance.domain.model;


import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;


@DisplayName("Test class PersonRefactor - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class PersonTest {

    private PersonRefactor malePerson;
    private PersonRefactor femaleFerson;

    @BeforeEach
    void setUp() {
    }

    @Test
    void person_Has_Gender_Code() {

        // Given
        String name = RandomStringUtils.randomAlphabetic(7);
        this.malePerson = new PersonRefactor(name, "M");
        this.femaleFerson = new PersonRefactor(name, "F");

        // When
        String maleGenderCode = this.malePerson.genderCode();
        String femaleGenderCode = this.femaleFerson.genderCode();

        // Then
        assertThat(maleGenderCode).isEqualTo("M");
        assertThat(femaleGenderCode).isEqualTo("F");
    }

    @Test
    void able_To_Generate_People_With_Gender_Code_And_Name() throws Exception {

        // Given
        List<String[]> data = List.of(
                new String[] { "name0", "F" },
                new String[] { "name1", "F" },
                new String[] { "name2", "M" },
                new String[] { "name3", "F" },
                new String[] { "name4", "M" },
                new String[] { "name5", "M" },
                new String[] { "name6", "F" },
                new String[] { "name7", "X" },
                new String[] { "name8", "F" });

        List<PersonRefactor> people = PersonRefactor.loadFromInput(data);

        // When
        long actualMaleAmt = people.stream()
                .filter(PersonRefactor::isMale)
                .count();

        long actualFemaleAmt = people.stream()
                .filter(PersonRefactor::isFemale)
                .count();

        long unknownGenderAmt = people.stream()
                .filter(p -> "X".equals(p.genderCode()))
                .count();

        // Then
        assertThat(actualMaleAmt).isEqualTo(3);
        assertThat(actualFemaleAmt).isEqualTo(5);
        assertThat(unknownGenderAmt).isOne();
    }

}///:~