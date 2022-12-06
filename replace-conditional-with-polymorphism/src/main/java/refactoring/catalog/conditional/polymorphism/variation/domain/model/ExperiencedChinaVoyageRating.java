//: refactoring.catalog.conditional.polymorphism.variation.domain.model.ExperiencedChinaVoyageRating


package refactoring.catalog.conditional.polymorphism.variation.domain.model;


import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;

import javax.annotation.concurrent.ThreadSafe;

@Value
@ThreadSafe
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
class ExperiencedChinaVoyageRating implements IVoyageRating {

    IVoyage voyage;

    IVoyageHistory history;

    @Override
    public int captainHistoryRiskInitValue() {
        return -1;
    }

    @Override
    public int historyLengthProfitFactor() {
        return (history().length() > 10) ? 1 : 0;
    }

    @Override
    public int voyageLengthProfitFactor() {

        int profitFactor = 3;

        if (voyage().length() > 12) {
            profitFactor += 1;
        }

        if (voyage().length() > 18) {
            profitFactor -= 1;
        }

        return profitFactor;
    }

}///:~