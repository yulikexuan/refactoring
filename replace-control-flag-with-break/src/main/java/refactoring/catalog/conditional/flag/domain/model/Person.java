//: refactoring.catalog.conditional.flag.domain.model.Person


package refactoring.catalog.conditional.flag.domain.model;

import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;

import javax.annotation.concurrent.ThreadSafe;


@Value
@ThreadSafe
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
class Person implements IPerson {

    String name;

    int age;

}///:~