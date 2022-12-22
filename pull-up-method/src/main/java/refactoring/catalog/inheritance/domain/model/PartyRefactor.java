//: refactoring.catalog.inheritance.domain.model.PartyRefactor


package refactoring.catalog.inheritance.domain.model;


import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;

import javax.annotation.concurrent.ThreadSafe;


abstract class PartyRefactor {

    long annualCost() {
        return monthlyCost() * 12;
    }

    long monthlyCost() {
        throw new UnsupportedOperationException();
    }

}

@Value
@ThreadSafe
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
class EmployeeRefactor extends PartyRefactor {
    long monthlyCost;
}


@Value
@ThreadSafe
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
class DepartmentRefactor extends PartyRefactor {
    long monthlyCost;
}

///:~