package refactoring.catalog.declaration.domain.service;


import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;
import refactoring.catalog.declaration.domain.model.Address;
import refactoring.catalog.declaration.domain.model.Customer;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test StatementService - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class UsRegionServiceTest {

    private Customer customer;
    private UsRegionService regionService;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        this.regionService = new UsRegionServiceImpl();
    }

    @ParameterizedTest
    @CsvSource({"MA, true", "CT, true", "ME, true", "VT, true", "NH, true", "RI, true",
            "AK, false", "OH, false", "TX, false", "UT, false", "WA, false", "WI, false"})
    void able_To_Know_If_A_Customer_Live_In_New_England_Region_Or_Not(
            String stateCode, boolean expectedInNewEngland) {

        // Given
        Customer customer = Customer.of(
                RandomStringUtils.randomAlphanumeric(7),
                Address.of(stateCode));

        // When
        boolean isActuallyInNewEngland = this.regionService.inNewEngland(customer);

        // Then
        assertThat(isActuallyInNewEngland).isEqualTo(expectedInNewEngland);
    }

}