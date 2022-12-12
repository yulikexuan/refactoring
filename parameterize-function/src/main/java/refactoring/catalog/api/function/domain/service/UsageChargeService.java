//: refactoring.catalog.api.function.domain.service.UsageChargeService


package refactoring.catalog.api.function.domain.service;


class UsageChargeService {

    long baseCharge(final long usage) {

        if (usage < 0) {
            return 0;
        }

//        final long amount =
//                bottomBand(usage) * 3 / 100 +
//                middleBand(usage) * 5 / 100 +
//                topBand(usage) * 7 / 100;

        final long amount =
                withinBand(usage, 0, 100) * 3 / 100 +
                withinBand(usage, 100, 200) * 5 / 100 +
                withinBand(usage, 200, Long.MAX_VALUE) * 7 / 100;

        return amount;
    }

//    long bottomBand(final long usage) {
//        return Math.min(usage, 100);
//    }

    /*
     * When looking to parameterize some related Funcs
     * - The approach is to take one of the Funcs and add parameters to it
     *   - with an eye to the other cases
     * - With Range-Oriented things like this
     *   - usually the place to start is with the middle range
     */
    long withinBand(long usage, long bottom, long top) {
        return (usage > bottom) ? Math.min(usage, top) - bottom : 0;
    }

//    long middleBand(final long usage) {
//        return (usage > 100) ? Math.min(usage, 200) - 100 : 0;
//    }

//    long topBand(final long usage) {
//        return (usage > 200) ? usage - 200 : 0;
//    }

}///:~