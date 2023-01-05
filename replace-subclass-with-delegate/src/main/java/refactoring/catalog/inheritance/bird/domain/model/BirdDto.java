//: refactoring.catalog.inheritance.bird.domain.model.BirdDTO


package refactoring.catalog.inheritance.bird.domain.model;


import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;

import javax.annotation.concurrent.ThreadSafe;


@Value
@ThreadSafe
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
public class BirdDto {

    String name;

    PlumageType plumage;

    int numberOfCoconuts;

    int voltage;

    boolean nailed;

}///:~