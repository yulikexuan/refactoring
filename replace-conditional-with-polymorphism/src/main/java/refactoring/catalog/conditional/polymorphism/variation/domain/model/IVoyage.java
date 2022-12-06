//: refactoring.catalog.conditional.polymorphism.variation.domain.model.IVoyage


package refactoring.catalog.conditional.polymorphism.variation.domain.model;


import java.util.List;


interface IVoyage {

    String ZONE_CHINA = "china";

    String ZONE_EAST_INDIES = "east-indies";

    List<String> HIGH_RISK_ZONES = List.of(ZONE_CHINA, ZONE_EAST_INDIES);

    int length();

    String zone();

    long profit();

//    static String rating(@NonNull final IVoyage voyage,
//                         @NonNull final IVoyageHistory history) {
//
//        final int voyageProfitFactor = voyageProfitFactor(voyage, history);
//
//        final int voyageRisk = voyage.risk();
//
//        final int captainHistoryRisk = captainHistoryRisk(voyage, history);
//
//        if ((voyageProfitFactor * 3) > (voyageRisk + captainHistoryRisk * 2)) {
//            return "A";
//        }
//
//        return "B";
//    }
//
//    static int captainHistoryRisk(@NonNull final IVoyage newVoyage,
//                                  @NonNull final IVoyageHistory history) {
//
//        int risk = 1;
//
//        if (history.length() < 5) {
//            risk += 4;
//        }
//
//        risk += history.countOfLoss();
//
//        if (ZONE_CHINA.equals(newVoyage.zone()) && history.hasDestination(ZONE_CHINA)) {
//            risk -= 2;
//        }
//
//        return Math.max(risk, 0);
//    }
//
//    static int voyageProfitFactor(@NonNull final IVoyage voyage,
//                                  @NonNull final IVoyageHistory history) {
//
//        int profitFactor = 2;
//
//        if (ZONE_CHINA.equals(voyage.zone())) {
//            profitFactor += 1;
//        }
//
//        if (ZONE_EAST_INDIES.equals(voyage.zone())) {
//            profitFactor += 1;
//        }
//
//        if (ZONE_CHINA.equals(voyage.zone()) && history.hasDestination(ZONE_CHINA)) {
//
//            profitFactor += 3;
//
//            if (history.length() > 10) {
//                profitFactor += 1;
//            }
//
//            if (voyage.length() > 12) {
//                profitFactor += 1;
//            }
//
//            if (voyage.length() > 18) {
//                profitFactor -= 1;
//            }
//
//        } else {
//
//            if (history.length() > 8) {
//                profitFactor += 1;
//            }
//            if (voyage.length() > 14) {
//                profitFactor -= 1;
//            }
//        }
//
//        return profitFactor;
//    }

}///:~