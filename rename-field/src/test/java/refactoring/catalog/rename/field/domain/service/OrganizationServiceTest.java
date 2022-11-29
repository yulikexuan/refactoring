package refactoring.catalog.rename.field.domain.service;


import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;
import refactoring.catalog.rename.field.domain.model.Organization;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import static org.mutabilitydetector.unittesting.MutabilityAssert.assertImmutable;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test refactoring.catalog.rename.field.domain.service.OrganizationService- ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class OrganizationServiceTest {

    private OrganizationService organizationService;

    @BeforeEach
    void setUp() {
        this.organizationService = OrganizationService.of();
    }

    @Test
    void class_Organization_Should_Be_Immutable() {
        assertImmutable(Organization.class);
    }

    @ParameterizedTest
    @CsvSource({"School, 2", "College, 2", "Department, 3", "Association, 2", "Institute, 1"})
    void able_To_Collect_All_Organization_With_Specified_Suffix(
            String suffix, int expectedCollectionSize) {

        // Given
        List<Organization> organizations = List.of(
                Organization.of(orgName() + " School", "CA"),
                Organization.of(orgName() + " College", "GB"),
                Organization.of(orgName() + " Department", "JP"),
                Organization.of(orgName() + " Association", "CN"),
                Organization.of(orgName() + " Institute", "US"),
                Organization.of(orgName() + " Department", "CN"),
                Organization.of(orgName() + " Association", "GB"),
                Organization.of(orgName() + " College", "CA"),
                Organization.of(orgName() + " Department", "GB"),
                Organization.of(orgName() + " School", "US"));

        // When
        Set<Organization> actualOrgCollection =
                this.organizationService.organizationsWithSuffix(
                        organizations, suffix);

        // Then
        assertThat(actualOrgCollection).hasSize(expectedCollectionSize);
    }

    private String orgName() {
        return RandomStringUtils.randomAlphabetic(7);
    }

}///:~