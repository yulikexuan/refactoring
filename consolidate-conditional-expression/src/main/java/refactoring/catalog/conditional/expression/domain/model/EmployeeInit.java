//: refactoring.catalog.conditional.expression.domain.model.Employee


package refactoring.catalog.conditional.expression.domain.model;


import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;

import javax.annotation.concurrent.ThreadSafe;


@Value
@ThreadSafe
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
class EmployeeInit {

    int seniority;

    int monthsDisabled;

    boolean partTime;

    boolean onVacation;

    int disabilityAmount() {

        /*
         * A sequence of conditional checks which all have the same result
         * And the result is the same
         */
        if (seniority < 2) {
            return 0;
        }

        if (monthsDisabled > 12) {
            return 0;
        }

        if (partTime) {
            return 0;
        }

        return seniority * 10 - monthsDisabled;
    }

    int paymentRate() {

        if (onVacation)
            if (seniority > 10)
                return 100;

        return 50;
    }

}///:~