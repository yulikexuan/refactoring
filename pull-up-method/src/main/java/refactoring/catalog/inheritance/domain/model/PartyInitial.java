//: refactoring.catalog.inheritance.domain.model.Party


package refactoring.catalog.inheritance.domain.model;


import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;

import javax.annotation.concurrent.ThreadSafe;


public class PartyInitial {

}


@Value
@ThreadSafe
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
class EmployeeInitial extends PartyInitial {

    long monthlyCost;

    long annualCost() {
        return this.monthlyCost * 12;
    }

}

@Value
@ThreadSafe
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
class DepartmentInitial extends PartyInitial {

    long monthlyCost;

    long totalAnnualCost() {
        return this.monthlyCost * 12;
    }

}

///:~