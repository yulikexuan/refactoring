//: refactoring.catalog.conditional.flag.domain.model.IPerson


package refactoring.catalog.conditional.flag.domain.model;


import lombok.NonNull;


public interface IPerson {

    String name();

    int age();

    static IPerson of(@NonNull final String name, final int age) {
        return Person.of(name, age);
    }

}///:~