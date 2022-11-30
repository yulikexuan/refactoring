package refactoring.catalog.change.reference.domain.refactor.service;


import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import refactoring.catalog.change.reference.domain.refactor.model.Person;
import refactoring.catalog.change.reference.domain.refactor.model.TelephoneNumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import static org.mutabilitydetector.unittesting.MutabilityAssert.assertImmutable;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test TelephoneNumberChangeService class - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class TelephoneNumberChangeServiceTest {

    private TelephoneNumberChangeService telephoneNumberChangeService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void class_TelephoneNumber_Should_Be_Immutable() {
        assertImmutable(TelephoneNumber.class);
    }

    @Test
    void replace_TelephoneNumber_When_Having_New_Office_Number() {

        // Given
        String personName = RandomStringUtils.randomAlphabetic(10);
        String areaCode = RandomStringUtils.randomNumeric(3);
        String areaNum = RandomStringUtils.randomNumeric(7);
        String newOfficeNum = RandomStringUtils.randomNumeric(7);

        TelephoneNumber telephoneNumber = TelephoneNumber.of(areaCode, areaNum);
        Person person = Person.of(personName, telephoneNumber);

        // When
        person.officeNumber(newOfficeNum);

        // Then
        assertThat(person.telephoneNumber()).isNotSameAs(telephoneNumber);
        assertThat(person.officeAreaCode()).isEqualTo(areaCode);
        assertThat(person.officeNumber()).isEqualTo(newOfficeNum);
    }

}///:~