//: refactoring.catalog.inheritance.domain.model.refactor.Employee


package refactoring.catalog.inheritance.domain.model.refactor;


import lombok.NonNull;
import lombok.Value;
import lombok.experimental.Accessors;

import javax.annotation.concurrent.ThreadSafe;


@Value
@ThreadSafe
@Accessors(fluent = true)
public class EmployeeRefactor extends Party {

    int id;

    long monthlyCost;

    private EmployeeRefactor(int id, String name, long monthlyCost) {

        super(name);

        this.id = id;
        this.monthlyCost = monthlyCost;
    }

    public static EmployeeRefactor of(final int id,
                                      @NonNull final String name,
                                      final long monthlyCost) {

        return new EmployeeRefactor(id, name, monthlyCost);
    }

}///:~