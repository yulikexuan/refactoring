//: refactoring.catalog.conditional.expression.domain.service.CapitalServiceInit


package refactoring.catalog.conditional.expression.domain.service;


import lombok.AllArgsConstructor;
import lombok.NonNull;
import refactoring.catalog.conditional.expression.domain.model.Instrument;

import javax.annotation.concurrent.ThreadSafe;


@ThreadSafe
@AllArgsConstructor(staticName = "of")
class CapitalServiceInit implements CapitalService {

    @Override
    public long adjustCapital(@NonNull final Instrument instrument) {

        long result = 0;

        if (instrument.capital() > 0) {
            if ((instrument.interestRate() > 0) && (instrument.duration() > 0)) {
                result = (instrument.income() / instrument.duration()) *
                        instrument.adjustmentFactor() / 10;
            }
        }

        return result;
    }

}///:~