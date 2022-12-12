package refactoring.catalog.api.function.domain.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test class UsageChargeService - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class UsageChargeServiceTest {

    private UsageChargeService usageChargeService;

    @BeforeEach
    void setUp() {
        this.usageChargeService = new UsageChargeService();
    }

    @ParameterizedTest
    @CsvSource({ "1000, 64", "99, 2", "101, 3", "201, 8", "500, 29", "150, 5", "70, 2"})
    void able_To_Calculate_The_Base_Charge(long usage, long expectedBaseCharge) {

        // Given


        // When
        long actualBaseCharge = this.usageChargeService.baseCharge(usage);

        // Then
        assertThat(actualBaseCharge).isEqualTo(expectedBaseCharge);
    }

}///:~