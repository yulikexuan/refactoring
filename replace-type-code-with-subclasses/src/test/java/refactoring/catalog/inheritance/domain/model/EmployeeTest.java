package refactoring.catalog.inheritance.domain.model;


import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.security.InvalidParameterException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test class EmployeeRefactor - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class EmployeeTest {


    @AfterEach
    void tearDown() {

    }

    @Test
    void wrong_Employ_Type_Will_Give_Exception() {

        // Given
        String type = RandomStringUtils.randomAlphabetic(11);
        String name = RandomStringUtils.randomAlphabetic(7);

        // When & Then
        assertThatThrownBy(() -> EmployeeRefactor.of(name, type))
                .isExactlyInstanceOf(InvalidParameterException.class);
    }

    @ParameterizedTest
    @CsvSource({"engineer, refactoring.catalog.inheritance.domain.model.Engineer",
            "manager, refactoring.catalog.inheritance.domain.model.Manager",
            "salesman, refactoring.catalog.inheritance.domain.model.EmployeeRefactor"})
    void able_To_Create_Different_Type_Of_Employee(
            String type, String className) throws Exception {

        // Given
        String name = RandomStringUtils.randomAlphabetic(7);
        EmployeeRefactor employee = EmployeeRefactor.of(name, type);

        // When
        String actualType = employee.type();

        // Then
        assertThat(actualType).isEqualTo(type);
        assertThat(employee).isInstanceOf(Class.forName(className));
    }



}///:~