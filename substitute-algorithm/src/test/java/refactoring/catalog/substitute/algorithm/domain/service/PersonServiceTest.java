package refactoring.catalog.substitute.algorithm.domain.service;


import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import refactoring.catalog.substitute.algorithm.domain.model.Person;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test class PersonService- ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class PersonServiceTest {

    private PersonService personService;

    @BeforeEach
    void setUp() {
        personService = new PersonService();
    }

    @Test
    void able_To_Find_Out_Candidate() {

        // Given
        Person[] people_1 = {
                Person.of(RandomStringUtils.randomAlphanumeric(7), 30),
                Person.of("Don", 50),
                Person.of(RandomStringUtils.randomAlphanumeric(7), 40),
                Person.of("John", 50),
        };

        Person[] people_2 = {
                Person.of(RandomStringUtils.randomAlphanumeric(7), 30),
                Person.of(RandomStringUtils.randomAlphanumeric(7), 50),
                Person.of(RandomStringUtils.randomAlphanumeric(7), 40),
                Person.of("John", 20),
        };

        Person[] people_3 = {
                Person.of(RandomStringUtils.randomAlphanumeric(7), 30),
                Person.of(RandomStringUtils.randomAlphanumeric(7), 50),
                Person.of("Kent", 40),
                Person.of("Don", 40),
        };

        Person[] people_4 = {
                Person.of(RandomStringUtils.randomAlphanumeric(7), 30),
                Person.of(RandomStringUtils.randomAlphanumeric(7), 50),
                Person.of(RandomStringUtils.randomAlphanumeric(7), 40),
                Person.of(RandomStringUtils.randomAlphanumeric(7), 20),
        };

        // When
        Person foundPerson_1 = this.personService.findPerson(people_1);
        Person foundPerson_2 = this.personService.findPerson(people_2);
        Person foundPerson_3 = this.personService.findPerson(people_3);
        Person foundPerson_4 = this.personService.findPerson(people_4);

        // Then
        assertThat(foundPerson_1.name()).isEqualTo("Don");
        assertThat(foundPerson_2.name()).isEqualTo("John");
        assertThat(foundPerson_3.name()).isEqualTo("Kent");
        assertThat(foundPerson_4).isNull();
    }

}///:~