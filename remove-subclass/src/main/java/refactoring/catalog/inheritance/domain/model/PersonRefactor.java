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
class PersonRefactor {

    private String name;

    private String genderCode;

    PersonRefactor(@NonNull final String name) {
        this.name = name;
    }

    PersonRefactor(@NonNull final String name,
                   @NonNull final String genderCode) {

        this.name = name;
        this.genderCode = genderCode;
    }

    public String genderCode() {
        return this.genderCode;
    }

    public boolean isMale() {
        return "M".equals(this.genderCode);
    }

    public boolean isFemale() {
        return "F".equals(this.genderCode);
    }

    static List<PersonRefactor> loadFromInput(
            @NonNull final List<String[]> personData) {

        return personData.stream()
                .map(PersonRefactor::personRefactorFunction)
                .toList();
    }

    static PersonRefactor personRefactorFunction(@NonNull final String[] data) {

        return switch (data[1]) {
                    case "M" -> new PersonRefactor(data[0], "M");
                    case "F" -> new PersonRefactor(data[0], "F");
                    default -> new PersonRefactor(data[0], "X");
               };
    }
}

//final class MaleRefactor extends PersonRefactor {
//
//    MaleRefactor(String name) {
//        super(name);
//    }
//
//    public String genderCode() {
//        return "M";
//    }
//}
//
//final class FemaleRefactor extends PersonRefactor {
//
//    FemaleRefactor(String name) {
//        super(name);
//    }
//
//    public String genderCode() {
//        return "F";
//    }
//}

///:~