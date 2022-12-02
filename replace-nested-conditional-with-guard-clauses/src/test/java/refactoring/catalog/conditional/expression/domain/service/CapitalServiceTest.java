package refactoring.catalog.conditional.expression.domain.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;
import refactoring.catalog.conditional.expression.domain.model.Instrument;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test class CapitalService - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class CapitalServiceTest {

    private CapitalService capitalServiceInit;

    private CapitalService capitalServiceRefactor;

    private Instrument instrument;

    @BeforeEach
    void setUp() {
        this.capitalServiceInit = CapitalServiceInit.of();
    }

    @ParameterizedTest
    @CsvSource({ "12345, 3, 12, 30000, 5, 1250",
            "30000, 4, 6, 50000, 2, 1666",
            "0, 4, 6, 50000, 2, 0",
            "-1, 4, 6, 50000, 2, 0",
            "20000, 0, 6, 50000, 2, 0",
            "20000, -1, 6, 50000, 2, 0",
            "30000, 4, 0, 50000, 2, 0",
            "30000, 4, -1, 50000, 2, 0"})
    void able_To_Adjust_Capital(
            long capital,
            int interestRate,
            int duration,
            long income,
            int adjustmentFactor,
            long expectedAdjustedCapital) {

        // Given
        this.instrument = Instrument.of(capital, interestRate, duration, income,
                adjustmentFactor);

        // When
        long actualAdjustedCapitalInit =
                this.capitalServiceInit.adjustCapital(instrument);

        long actualAdjustedCapitalRefactor =
                this.capitalServiceInit.adjustCapital(instrument);

        // Then
        assertThat(actualAdjustedCapitalInit).isEqualTo(expectedAdjustedCapital);
        assertThat(actualAdjustedCapitalRefactor).isEqualTo(expectedAdjustedCapital);
    }

}///:~