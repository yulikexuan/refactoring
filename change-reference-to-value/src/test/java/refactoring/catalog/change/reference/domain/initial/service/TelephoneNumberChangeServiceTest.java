package refactoring.catalog.change.reference.domain.initial.service;


import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import refactoring.catalog.change.reference.domain.initial.model.Person;
import refactoring.catalog.change.reference.domain.initial.model.TelephoneNumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;


@DisplayName("Test initial TelephoneNumberChangeService class- ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class TelephoneNumberChangeServiceTest {

    private TelephoneNumberChangeService telephoneNumberChangeService;

    @BeforeEach
    void setUp() {
        this.telephoneNumberChangeService = new TelephoneNumberChangeService();
    }

    @Test
    void able_To_Change_Office_Number_Of_Person() {

        // Given
        String personName = RandomStringUtils.randomAlphabetic(10);
        String areaCode = RandomStringUtils.randomNumeric(3);
        String areaNum = RandomStringUtils.randomNumeric(7);
        TelephoneNumber telephoneNumber = TelephoneNumber.of(areaCode, areaNum);

        Person person = Person.of(personName, telephoneNumber);

        String newAreaNumber = RandomStringUtils.randomNumeric(7);

        // When
        person.officeNumber(newAreaNumber);

        // Then
        assertThat(person.telephoneNumber()).isSameAs(telephoneNumber);
        assertThat(person.officeAreaCode()).isSameAs(telephoneNumber.officeAreaCode());
        assertThat(person.officeNumber()).isSameAs(newAreaNumber);
    }

}///:~