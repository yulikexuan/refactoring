//: refactoring.catalog.inheritance.domain.model.Employee


package refactoring.catalog.inheritance.domain.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.security.InvalidParameterException;
import java.util.List;


@Getter
@Setter
@Accessors(fluent = true)
@ToString
class Employee {

    static final List<String> ALL_EMPLOYEE_TYPES =
            List.of("engineer", "manager", "salesman");

    private String name;
    private String type;

    public Employee(String name, String type) {

        this.validateType(type);

        this.name = name;
        this.type = type;
    }

    private void validateType(String type) {
        if (!ALL_EMPLOYEE_TYPES.contains(type)) {
            throw new InvalidParameterException();
        }
    }

}///:~