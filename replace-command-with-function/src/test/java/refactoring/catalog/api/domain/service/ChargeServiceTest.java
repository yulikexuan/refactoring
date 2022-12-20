package refactoring.catalog.api.domain.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import refactoring.catalog.api.domain.model.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test class ChargeService - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class ChargeServiceTest {

    @Mock
    private Customer customer;

    @Mock
    private Usage usage;

    @Mock
    private Provider provider;

    private ChargeService chargeService;

    @BeforeEach
    void setUp() {
        this.chargeService = new ChargeService();
    }

    @ParameterizedTest
    @CsvSource({ "110, 10, 33, 44",
            "95, 30, 29, 57",
            "95, 10, 29, 38"})
    void able_To_Calculate_Usage_Charge(int baseRate,
                                        int usageAmt,
                                        int connCharge,
                                        long expectedCharge) {

        // Given
        given(this.customer.baseRate()).willReturn(baseRate);

        given(this.usage.amount()).willReturn(usageAmt);

        given(this.provider.connectionCharge()).willReturn(connCharge);

        // When
        long actualCharge = this.chargeService.charge(
                this.customer, this.usage, this.provider);

        // Then
        assertThat(actualCharge).isEqualTo(expectedCharge);
    }

}///:~