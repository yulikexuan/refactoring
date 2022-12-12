package refactoring.catalog.api.function.domain.model;


import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test class IEmployee - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class EmployeeTest {

    private IEmployee employee;

    private IEmployee raisedEmployee;

    @BeforeEach
    void setUp() {
    }

    @ParameterizedTest
    @CsvSource({ "30000, 31500, 33000",
            "50000, 52500, 55000",
            "40000, 42000, 44000"})
    void able_To_Give_Salary_Raise_To_Employee(long salary,
                                               long expectedFivePercentRaiseSalary,
                                               long expectedTenPercentRaiseSalary) {

        // Given
        employee = IEmployee.of(RandomStringUtils.randomAlphabetic(7), salary);

        // When
        raisedEmployee = IEmployee.raise(employee, 5);

        // Then
        assertThat(raisedEmployee.salary()).isEqualTo(expectedFivePercentRaiseSalary);

        // When
        raisedEmployee = IEmployee.raise(employee, 10);

        // Then
        assertThat(raisedEmployee.salary()).isEqualTo(expectedTenPercentRaiseSalary);
    }

}///:~