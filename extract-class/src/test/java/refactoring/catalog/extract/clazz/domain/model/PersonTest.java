package refactoring.catalog.extract.clazz.domain.model;


import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import static org.mutabilitydetector.unittesting.MutabilityAssert.assertImmutable;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test Person Class - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class PersonTest {

    private String name;
    private String areaCode;
    private String telNumber;

    private ThreadLocalRandom random;

    private Person person;

    @BeforeEach
    void setUp() {
        this.random = ThreadLocalRandom.current();
        this.name = RandomStringUtils.randomAlphabetic(7);
        this.areaCode = Integer.toString(
                this.random.nextInt(100, 1000));
        this.telNumber = Long.toString(
                this.random.nextLong(1000000, 10000000));
        this.person = Person.of(this.name, this.areaCode, this.telNumber);
    }

    @Test
    void class_Person_Should_Be_Immutable() {
        assertImmutable(Person.class);
    }

    @Test
    void person_Has_Office_Tel_Number() {

        // Given
        String expectedOfficeTelNumber = String.format(
                Person.TELEPHONE_NUMBER_TEMPLATE, this.areaCode, this.telNumber);

        // When
        String actualOfficeTelNumber = this.person.officeTelephoneNumber();

        // Then
        assertThat(actualOfficeTelNumber).isEqualTo(expectedOfficeTelNumber);
    }

}///:~