package refactoring.catalog.extract.clazz.domain.model;


import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import static org.mutabilitydetector.unittesting.MutabilityAssert.assertImmutable;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test Person Class - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class PersonTest {

    private String name;

    private TelephoneNumber telephoneNumber;

    private Person person;

    @BeforeEach
    void setUp() {
        this.name = RandomStringUtils.randomAlphabetic(7);

    }

    @Test
    void class_Person_Should_Be_Immutable() {
        assertImmutable(Person.class);
    }

    @ParameterizedTest
    @CsvSource({"514, 1234567, 514-1234567",
            "438, 7654321, 438-7654321",
            "123, 0123456, 123-0123456",
            "231, 1012345, 231-1012345"})
    void person_Has_Office_Tel_Number(
            String areaCode, String telNumber, String expectedOfficeTelNumber) {

        // Given
        TelephoneNumber tn = TelephoneNumber.of(areaCode, telNumber);
        this.person = Person.of(name, tn);

        // When
        String actualOfficeTelNum = this.person.officeTelephoneNumber();

        // Then
        assertThat(actualOfficeTelNum).isEqualTo(expectedOfficeTelNumber);
    }

}///:~