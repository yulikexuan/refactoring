//: refactoring.catalog.substitute.algorithm.domain.service.PersonService


package refactoring.catalog.substitute.algorithm.domain.service;


import refactoring.catalog.substitute.algorithm.domain.model.Person;


public class PersonService {

    Person findPerson(Person[] people) {

        for (int i = 0; i < people.length; i++) {

            if (people[i].name().equals("Don")) {
                return people[i];
            }

            if (people[i].name().equals("John")) {
                return people[i];
            }

            if (people[i].name().equals("Kent")) {
                return people[i];
            }
        }

        return null;
    }

}///:~