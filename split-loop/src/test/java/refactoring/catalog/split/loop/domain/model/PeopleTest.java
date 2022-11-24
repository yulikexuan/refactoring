package refactoring.catalog.split.loop.domain.model;


import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.annotation.concurrent.Immutable;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test class People - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class PeopleTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void able_To_Count_Youngest_Age_And_Total_Salary_Of_People() {

        // Given
        final int expectedYoungest = 23;
        final long expectedTotalSalary = 582;

        List<People> people = List.of(
                People.of(23, 35),
                People.of(53, 89),
                People.of(40, 60),
                People.of(35, 55),
                People.of(54, 98),
                People.of(60, 100),
                People.of(65, 110),
                People.of(27, 35));

        // When
        ImmutablePair<Integer, Long> statistics = People.count(people);

        // Then
        assertThat(statistics.left).isEqualTo(expectedYoungest);
        assertThat(statistics.right).isEqualTo(expectedTotalSalary);
    }

}///:~