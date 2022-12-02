//: refactoring.catalog.conditional.expression.domain.service.CapitalServiceRefactor


package refactoring.catalog.conditional.expression.domain.service;


import lombok.NonNull;
import refactoring.catalog.conditional.expression.domain.model.Instrument;


class CapitalServiceRefactor implements CapitalService {

    @Override
    public long adjustCapital(@NonNull final Instrument instrument) {

        if (!isAbleToRecalculate(instrument)) return 0;

        return recalculateCapital(instrument);
    }

    long recalculateCapital(Instrument instrument) {
        return (instrument.income() / instrument.duration()) *
                instrument.adjustmentFactor() / 10;
    }

    boolean isAbleToRecalculate(@NonNull final Instrument instrument) {
        return (instrument.capital() > 0) &&
                (instrument.interestRate() > 0) &&
                (instrument.duration() > 0);
    }

}///:~