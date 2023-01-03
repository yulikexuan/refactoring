//: refactoring.catalog.inheritance.domain.model.init.Employee


package refactoring.catalog.inheritance.domain.model.init;


import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;

import javax.annotation.concurrent.ThreadSafe;


@Value
@ThreadSafe
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
class Employee {

    int id;

    String name;

    long monthlyCost;

    public long annualCost() {
        return this.monthlyCost * 12;
    }

}///:~