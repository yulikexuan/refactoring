package refactoring.catalog.funcombinetrans.domain.model;


import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import refactoring.catalog.funcombinetrans.domain.service.TaxRateService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import static org.mockito.BDDMockito.given;
import static org.mutabilitydetector.unittesting.MutabilityAssert.assertImmutable;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test EnrichedTeaReadingImpl class - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class EnrichedTeaReadingTest {

    @Mock
    private TaxRateService taxRateService;

    private String customer;

    private EnrichedTeaReading enrichedTeaReading;

    @BeforeEach
    void setUp() {
        this.customer = RandomStringUtils.randomAlphabetic(4);
    }

    @Test
    void the_EnrichedTeaReadingImpl_class_Should_Be_Immutable() {
        assertImmutable(EnrichedTeaReadingImpl.class);
    }

    @ParameterizedTest
    @CsvSource({"70, 1, 2022, 2, 200, 0",
            "40, 3, 2022, 4, 100, 60",
            "60, 8, 2022, 5, 200, 100"})
    void able_To_Enrich_Tea_Reading(
            int quantity, int month, int year,
            int baseRate, int threshold, int expectTaxableCharge) {

        // Given
        final TeaReading teaReading = TeaReading.of(customer, quantity, month, year);

        given(this.taxRateService.baseRate(month, year)).willReturn(baseRate);
        given(this.taxRateService.taxThreshold(year)).willReturn(threshold);

        this.enrichedTeaReading = EnrichedTeaReading.enrichTeaReading(
                teaReading, this.taxRateService);

        // When
        int taxableCharge = this.enrichedTeaReading.taxableCharge();

        // Then
        assertThat(this.enrichedTeaReading.customer())
                .isEqualTo(teaReading.customer());

        assertThat(this.enrichedTeaReading.quantity())
                .isEqualTo(teaReading.quantity());

        assertThat(this.enrichedTeaReading.month()).isEqualTo(teaReading.month());

        assertThat(this.enrichedTeaReading.year()).isEqualTo(teaReading.year());

        assertThat(taxableCharge).isEqualTo(expectTaxableCharge);
    }

}///:~