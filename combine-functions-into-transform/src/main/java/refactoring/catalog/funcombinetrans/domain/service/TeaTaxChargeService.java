//: refactoring.catalog.funcombine.domain.service.TaxChargeService


package refactoring.catalog.funcombinetrans.domain.service;


import lombok.AllArgsConstructor;
import lombok.NonNull;
import refactoring.catalog.funcombinetrans.domain.model.TeaReading;


@AllArgsConstructor(staticName = "of")
public class TeaTaxChargeService {

    private final TaxRateService taxRateService;

    public int baseCharge(@NonNull final TeaReading teaReading) {
        final int month = teaReading.month();
        final int year = teaReading.year();
        final int quantity = teaReading.quantity();
        return (taxRateService.baseRate(month, year) * quantity);
    }

    public int taxCharge(@NonNull final TeaReading teaReading) {

        final int baseCharge = this.baseCharge(teaReading);
        final int year = teaReading.year();

        return Math.max(0, baseCharge - taxRateService.taxThreshold(year));
    }

}///:~