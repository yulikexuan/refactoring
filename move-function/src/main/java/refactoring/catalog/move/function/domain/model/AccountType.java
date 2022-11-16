package refactoring.catalog.move.function.domain.model;


import lombok.NonNull;

import java.util.function.IntFunction;


public enum AccountType {

    BASIC(AccountType::basicTypeOverdraftCharge),
    REGULAR(AccountType::basicTypeOverdraftCharge),
    PREMIUM(AccountType::premiumCharge);

    static final int BASE_OVERDRAWN_DAYS = 7;
    static final long BASE_OVERDRAWN_CHARGE = 1000;

    private final IntFunction<Long> overdraftCharge;

    AccountType(@NonNull final IntFunction<Long> overdraftCharge) {
        this.overdraftCharge = overdraftCharge;
    }

    public long calcOverdraftCharge(int daysOverdrawn) {
        return this.overdraftCharge.apply(daysOverdrawn);
    }

    private static long basicTypeOverdraftCharge(final int daysOverdrawn) {
        return daysOverdrawn * 175;
    }

    private static long premiumCharge(final int daysOverdrawn) {

        return (daysOverdrawn <= BASE_OVERDRAWN_DAYS) ?
                BASE_OVERDRAWN_CHARGE :
                BASE_OVERDRAWN_CHARGE + (daysOverdrawn - BASE_OVERDRAWN_DAYS) * 85;
    }

}