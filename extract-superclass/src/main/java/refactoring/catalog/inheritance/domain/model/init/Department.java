//: refactoring.catalog.inheritance.domain.model.init.Department


package refactoring.catalog.inheritance.domain.model.init;


import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.Accessors;

import java.util.List;


@Value
@Accessors(fluent = true)
class Department {

    String name;

    List<Employee> staff;

    private Department(String name, List<Employee> staff) {
        this.name = name;
        this.staff = ImmutableList.copyOf(staff);
    }

    public static Department of(@NonNull final String name,
                                @NonNull final List<Employee> staff) {

        return new Department(name, staff);
    }

    public List<Employee> staff() {
        return ImmutableList.copyOf(this.staff);
    }

    public int headCount() {
        return this.staff.size();
    }

    public long totalMonthlyCost() {
        return this.staff.stream().mapToLong(Employee::monthlyCost).sum();
    }

    public long totalAnnualCost() {
        return this.totalMonthlyCost() * 12;
    }

}///:~