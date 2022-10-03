package refactoring.catalog.funcombine.domain.service;


import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import refactoring.catalog.funcombine.domain.model.TeaReading;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test TeaTaxService - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class TeaTaxServiceTest {

    @Mock
    private TaxRateService taxRateService;

    private TeaTaxChargeService teaTaxChargeService;

    private String customer;

    @BeforeEach
    void setUp() {
        this.teaTaxChargeService = TeaTaxChargeService.of(this.taxRateService);
        this.customer = RandomStringUtils.randomAlphabetic(4);
    }

    @ParameterizedTest
    @CsvSource({"70, 1, 2022, 2, 200, 0",
            "40, 3, 2022, 4, 100, 60",
            "60, 8, 2022, 5, 200, 100"})
    void able_To_Calculate_Tax_Charge_Of_A_Tea_Reading(
            int quantity, int month, int year,
            int baseRate, int threshold, int expectTaxCharge) {

        // Given
        TeaReading teaReading = TeaReading.of(customer, quantity, month, year);

        given(this.taxRateService.baseRate(month, year)).willReturn(baseRate);
        given(this.taxRateService.taxThreshold(year)).willReturn(threshold);

        // When
        int taxCharge = this.teaTaxChargeService.taxCharge(teaReading);

        // Then
        assertThat(taxCharge).isEqualTo(expectTaxCharge);
    }

}///:~