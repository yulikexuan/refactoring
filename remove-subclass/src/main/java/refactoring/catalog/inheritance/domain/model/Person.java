//: refactoring.catalog.inheritance.domain.model.Person


package refactoring.catalog.inheritance.domain.model;


import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;


@Getter
@Setter
@Accessors(fluent = true)
class Person {

    private String name;

    Person(String name) {
        this.name = name;
    }

    public String genderCode() {
        return "X";
    }

    static List<Person> loadFromInput(
            @NonNull final List<String[]> personData) {

        return personData.stream()
                .map(data ->
                        switch (data[1]) {
                            case "M" -> new Male(data[0]);
                            case "F" -> new Female(data[0]);
                            default -> new Person(data[0]);
                        })
                .toList();
    }
}

final class Male extends Person {

    Male(String name) {
        super(name);
    }

    public String genderCode() {
        return "M";
    }
}

final class Female extends Person {

    Female(String name) {
        super(name);
    }

    public String genderCode() {
        return "F";
    }
}

///:~