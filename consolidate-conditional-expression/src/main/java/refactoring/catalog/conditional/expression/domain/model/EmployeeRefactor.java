//: refactoring.catalog.conditional.expression.domain.model.EmployeeRefactor


package refactoring.catalog.conditional.expression.domain.model;


import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;

import javax.annotation.concurrent.ThreadSafe;


@Value
@ThreadSafe
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
class EmployeeRefactor {

    int seniority;

    int monthsDisabled;

    boolean partTime;

    boolean onVacation;

    int disabilityAmount() {
        return isNotEligibleForDisability() ? 0 : calcDisabilityAmount();
    }

    int calcDisabilityAmount() {
        return seniority * 10 - monthsDisabled;
    }

    boolean isNotEligibleForDisability() {
        return (seniority < 2) || (monthsDisabled > 12) || (partTime);
    }

    int paymentRate() {
        return isSeniorVacation() ? 100 : 50;
    }

    private boolean isSeniorVacation() {
        return onVacation && seniority > 10;
    }

}///:~