//: refactoring.catalog.substitute.algorithm.domain.model.Person


package refactoring.catalog.substitute.algorithm.domain.model;


import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;


@Value
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
public class Person {

    String name;
    int age;

}///:~