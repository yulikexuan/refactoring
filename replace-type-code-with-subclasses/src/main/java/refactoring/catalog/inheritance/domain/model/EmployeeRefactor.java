//: refactoring.catalog.inheritance.domain.model.EmployeeRefactor


package refactoring.catalog.inheritance.domain.model;


import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.security.InvalidParameterException;
import java.util.List;


@Getter
@Setter
@Accessors(fluent = true)
@ToString
public class EmployeeRefactor {

    static final List<String> ALL_EMPLOYEE_TYPES =
            List.of("engineer", "manager", "salesman");

    private String name;
    private String type;

    EmployeeRefactor(String name, String type) {

        this.validateType(type);

        this.name = name;
        this.type = type;
    }

    private void validateType(String type) {
        if (!ALL_EMPLOYEE_TYPES.contains(type)) {
            throw new InvalidParameterException();
        }
    }

    public static EmployeeRefactor of(@NonNull final String name,
                                      @NonNull final String type) {

        return switch (type) {
            case "engineer" -> new Engineer(name);
            case "manager" -> new Manager(name);
            case "salesman" -> new Salesman(name);
            default -> new EmployeeRefactor(name, type);
        };
    }

}


@ToString
final class Engineer extends EmployeeRefactor {

    Engineer(String name) {
        super(name, "engineer");
    }
}

@ToString
final class Salesman extends EmployeeRefactor {

    Salesman(String name) {
        super(name, "salesman");
    }
}

@ToString
final class Manager extends EmployeeRefactor {

    Manager(String name) {
        super(name, "manager");
    }
}

///:~