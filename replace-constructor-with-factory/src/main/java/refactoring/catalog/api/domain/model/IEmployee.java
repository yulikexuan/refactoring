//: refactoring.catalog.api.domain.model.IEmployee


package refactoring.catalog.api.domain.model;


import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.Accessors;

import javax.annotation.concurrent.ThreadSafe;


public interface IEmployee {

    enum TypeCode {

        ENGINEER("E"),

        MANAGER("M"),

        SALESMAN("S");

        private String code;

        TypeCode(String code) {
            this.code = code;
        }

        public IEmployee newEmployee(@NonNull final String name) {
            return EmployeeRefactor.of(name, this);
        }

    }

    String name();

    TypeCode typeCode();

}

@Value
@ThreadSafe
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
class EmployeeRefactor implements IEmployee {

    String name;

    TypeCode typeCode;

}

@Value
@ThreadSafe
@Accessors(fluent = true)
class EmployeeInit implements IEmployee {

    public EmployeeInit(String name, TypeCode typeCode) {
        this.name = name;
        this.typeCode = typeCode;
    }

    String name;

    TypeCode typeCode;

}

///:~