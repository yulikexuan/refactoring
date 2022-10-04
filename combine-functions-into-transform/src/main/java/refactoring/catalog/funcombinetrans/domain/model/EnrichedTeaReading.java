//: refactoring.catalog.funcombinetrans.domain.model.EnrichedTeaReading


package refactoring.catalog.funcombinetrans.domain.model;


import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.Accessors;
import refactoring.catalog.funcombinetrans.domain.service.TaxRateService;


public sealed interface EnrichedTeaReading permits EnrichedTeaReadingImpl {

    String customer();

    int quantity();

    int month();

    int year();

    int baseTaxCharge();

    int taxableCharge();

    static EnrichedTeaReading enrichTeaReading(
            @NonNull final TeaReading teaReading,
            @NonNull final TaxRateService taxRateService) {

        final int month = teaReading.month();
        final int year = teaReading.year();
        final int quantity = teaReading.quantity();

        final int baseTaxCharge = taxRateService.baseRate(month, year) * quantity;

        final int taxableCharge =
                Math.max(0, baseTaxCharge - taxRateService.taxThreshold(year));

        return EnrichedTeaReadingImpl.of(
                teaReading.customer(),
                quantity,
                month,
                year,
                baseTaxCharge,
                taxableCharge);
    }

}


@Value
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
final class EnrichedTeaReadingImpl implements EnrichedTeaReading {

    private final String customer;

    private final int quantity;

    private final int month;

    private final int year;

    private final int baseTaxCharge;

    private final int taxableCharge;

}///:~