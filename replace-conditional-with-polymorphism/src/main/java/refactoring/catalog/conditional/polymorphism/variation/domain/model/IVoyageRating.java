//: refactoring.catalog.conditional.polymorphism.variation.domain.model.IVoyageRating


package refactoring.catalog.conditional.polymorphism.variation.domain.model;


import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.Accessors;

import javax.annotation.concurrent.ThreadSafe;

import static refactoring.catalog.conditional.polymorphism.variation.domain.model.IVoyage.*;


public interface IVoyageRating {

    IVoyage voyage();

    IVoyageHistory history();

    static IVoyageRating of(@NonNull final IVoyage voyage,
                            @NonNull final IVoyageHistory history) {

        return isChinaVoyage(voyage, history) ?
                ExperiencedChinaVoyageRating.of(voyage, history) :
                GenericVoyageRating.of(voyage, history);
    }

    static boolean isChinaVoyage(@NonNull final IVoyage voyage,
                                 @NonNull final IVoyageHistory history) {

        return "china".equals(voyage.zone()) && history.hasDestination("china");
    }

    default String rate() {

        final int voyageProfitFactor = voyageProfitFactor();

        final int voyageRisk = voyageRisk();

        final int captainHistoryRisk = captainHistoryRisk();

        if ((voyageProfitFactor * 3) > (voyageRisk + captainHistoryRisk * 2)) {
            return "A";
        }

        return "B";
    }

    default int voyageRisk() {

        int risk = 1;

        if (voyage().length() > 4) {
            risk += 2;
        }

        if (voyage().length() > 8) {
            risk += voyage().length() - 8;
        }

        if (HIGH_RISK_ZONES.contains(voyage().zone())) {
            risk += 4;
        }

        return Math.max(risk, 0);
    }

    default int captainHistoryRiskInitValue() {
        return 1;
    }

    default int captainHistoryRisk() {

        int risk = captainHistoryRiskInitValue();

        if (history().length() < 5) {
            risk += 4;
        }

        risk += history().countOfLoss();

        return Math.max(risk, 0);
    }

    default int voyageProfitFactor() {

        int profitFactor = 2;

        if (ZONE_CHINA.equals(voyage().zone())) {
            profitFactor += 1;
        }

        if (ZONE_EAST_INDIES.equals(voyage().zone())) {
            profitFactor += 1;
        }

        profitFactor += historyLengthProfitFactor();

        profitFactor += voyageLengthProfitFactor();

        return profitFactor;
    }

    default int voyageLengthProfitFactor() {
        return (voyage().length() > 14) ? -1 : 0;
    }

    default int historyLengthProfitFactor() {
        return (history().length() > 8) ? 1 : 0;
    }

}

@Value
@ThreadSafe
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
class GenericVoyageRating implements IVoyageRating {

    IVoyage voyage;

    IVoyageHistory history;

}///:~