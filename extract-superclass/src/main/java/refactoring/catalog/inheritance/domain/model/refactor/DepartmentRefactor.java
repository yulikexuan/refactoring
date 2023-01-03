//: refactoring.catalog.inheritance.domain.model.refactor.DepartmentRefactor


package refactoring.catalog.inheritance.domain.model.refactor;


import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.Accessors;

import javax.annotation.concurrent.ThreadSafe;
import java.util.List;


@Value
@ThreadSafe
@Accessors(fluent = true)
public class DepartmentRefactor extends Party {

    List<EmployeeRefactor> staff;

    private DepartmentRefactor(String name, List<EmployeeRefactor> staff) {
        super(name);
        this.staff = staff;
    }

    public static DepartmentRefactor of(
            @NonNull final String name,
            @NonNull final List<EmployeeRefactor> staff) {

        return new DepartmentRefactor(name, ImmutableList.copyOf(staff));
    }

    public List<EmployeeRefactor> staff() {
        return ImmutableList.copyOf(this.staff);
    }

    public int headCount() {
        return this.staff.size();
    }

    public long monthlyCost() {
        return this.staff.stream().mapToLong(EmployeeRefactor::monthlyCost).sum();
    }

}///:~