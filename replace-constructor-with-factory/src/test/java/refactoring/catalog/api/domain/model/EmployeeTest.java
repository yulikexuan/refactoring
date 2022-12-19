package refactoring.catalog.api.domain.model;


import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import static refactoring.catalog.api.domain.model.IEmployee.TypeCode;


@DisplayName("Test refactoring.catalog.api.domain.model.IEmployee- ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class EmployeeTest {

    @BeforeEach
    void setUp() {
    }

    @ParameterizedTest
    @CsvSource({ "ENGINEER", "MANAGER", "SALESMAN" })
    void able_To_Create_Different_Employee_Based_On_Type_Code(TypeCode typeCode) {

        // Given
        String name = RandomStringUtils.randomAlphabetic(7);

        // When
        IEmployee newEmployee = typeCode.newEmployee(name);

        // Then
        assertThat(newEmployee.typeCode()).isSameAs(typeCode);
    }

}///:~