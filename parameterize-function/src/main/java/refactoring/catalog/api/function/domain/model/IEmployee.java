//: refactoring.catalog.api.function.domain.model.IEmployee


package refactoring.catalog.api.function.domain.model;


import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.Accessors;

import javax.annotation.concurrent.ThreadSafe;


public interface IEmployee {

    String name();

    long salary();

    static IEmployee of(@NonNull final String name, final long salary) {
        return Employee.of(name, salary);
    }

    static IEmployee raise(@NonNull final IEmployee employee,
                           final int raiseFactor) {

        long newSalary = employee.salary() * (100 + raiseFactor) / 100;

        return of(employee.name(), newSalary);
    }

//    static IEmployee tenPercentRaise(@NonNull final IEmployee employee) {
//
//        long newSalary = employee.salary() * 110 / 100;
//
//        return of(employee.name(), newSalary);
//    }
//
//    static IEmployee fivePercentRaise(@NonNull final IEmployee employee) {
//
//        long newSalary = employee.salary() * 105 / 100;
//
//        return of(employee.name(), newSalary);
//    }

}

@Value
@ThreadSafe
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
class Employee implements IEmployee {

    String name;

    long salary;

}///:~