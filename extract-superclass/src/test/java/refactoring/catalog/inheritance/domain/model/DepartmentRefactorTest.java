package refactoring.catalog.inheritance.domain.model;


import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.mutabilitydetector.unittesting.AllowedReason;
import refactoring.catalog.inheritance.domain.model.refactor.DepartmentRefactor;
import refactoring.catalog.inheritance.domain.model.refactor.EmployeeRefactor;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import static org.mutabilitydetector.unittesting.MutabilityAssert.assertImmutable;
import static org.mutabilitydetector.unittesting.MutabilityAssert.assertInstancesOf;
import static org.mutabilitydetector.unittesting.MutabilityMatchers.areImmutable;


@DisplayName("Test class DepartmentRefactor - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class DepartmentRefactorTest {

    private ThreadLocalRandom random;

    @BeforeEach
    void setUp() {
        this.random = ThreadLocalRandom.current();
    }

    @Test
    void class_Employee_Should_Be_Immutable() {
        assertImmutable(EmployeeRefactor.class);
    }

    @Test
    void class_Department_Should_Be_Immutable() {
        assertInstancesOf(DepartmentRefactor.class, areImmutable(),
                AllowedReason.assumingFields("staff")
                        .areSafelyCopiedUnmodifiableCollectionsWithImmutableElements());
    }

    @Test
    void class_Department_Knows_Annual_Cost() {

        // Given
        long[] staffMonthlyCosts = {
                this.random.nextLong(100, 999),
                this.random.nextLong(100, 999),
                this.random.nextLong(100, 999),
                this.random.nextLong(100, 999),
                this.random.nextLong(100, 999),
                this.random.nextLong(100, 999),
                this.random.nextLong(100, 999),
        };

        long expectedTotalMonthlyCost = Arrays.stream(staffMonthlyCosts).sum();
        long expectedAnnualCost = expectedTotalMonthlyCost * 12;

        int expectedStaffCount = staffMonthlyCosts.length;
        List<EmployeeRefactor> staff = IntStream.range(0, 7)
                .mapToObj(i -> EmployeeRefactor.of(i,
                        RandomStringUtils.randomAlphabetic(7),
                        staffMonthlyCosts[i]))
                .toList();
        DepartmentRefactor department = DepartmentRefactor.of(
                RandomStringUtils.randomAlphabetic(4), staff);

        // When
        long actualAnnualCost = department.totalAnnualCost();

        // Then
        assertThat(actualAnnualCost).isEqualTo(expectedAnnualCost);
    }

}///:~