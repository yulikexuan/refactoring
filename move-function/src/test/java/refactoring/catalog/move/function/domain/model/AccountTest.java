package refactoring.catalog.move.function.domain.model;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import static org.mutabilitydetector.unittesting.MutabilityAssert.assertImmutable;
import static refactoring.catalog.move.function.domain.model.Account.BASIC_CHARGE;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test class Account - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class AccountTest {

    @Test
    void class_Account_Should_Be_Immutable() {
        assertImmutable(Account.class);
    }

    @ParameterizedTest
    @EnumSource(value = AccountType.class)
    void all_Account_Type_Have_The_Same_Basic_Charge_Without_Overdrawing(
            AccountType accountType) {

        // Given
        Account account = Account.of(accountType, 0);

        // When
        long actualBankCharge = account.bankCharge();

        // Then
        assertThat(actualBankCharge).isEqualTo(BASIC_CHARGE);
    }

    @ParameterizedTest
    @CsvSource({"BASIC, 1, 625",
            "BASIC, 2, 800",
            "BASIC, 3, 975",
            "REGULAR, 1, 625",
            "REGULAR, 2, 800",
            "REGULAR, 3, 975"})
    void non_Premium_Account_Type_Have_The_Same_Bank_Charge_With_Overdrawing(
            AccountType accountType, int daysOverdrawn, long expectedCharge) {

        // Given
        Account account = Account.of(accountType, daysOverdrawn);

        // When
        long actualBankCharge = account.bankCharge();

        // Then
        assertThat(actualBankCharge).isEqualTo(expectedCharge);
    }

    @ParameterizedTest
    @CsvSource({"2, 1450",
            "5, 1450",
            "7, 1450",
            "8, 1535",
            "10, 1705",
            "12, 1875",
            "14, 2045"})
    void premium_Account_Type_Has_Flexible_Charge_With_Different_Overdrawn_Days(
            int daysOverdrawn, int expectedCharge) {

        // Given
        Account account = Account.of(AccountType.PREMIUM, daysOverdrawn);

        // When
        long actualCharge = account.bankCharge();

        // Then
        assertThat(actualCharge).isEqualTo(expectedCharge);
    }

}///:~