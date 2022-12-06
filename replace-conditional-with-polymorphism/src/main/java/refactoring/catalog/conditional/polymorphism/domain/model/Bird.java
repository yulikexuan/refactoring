//: refactoring.catalog.conditional.polymorphism.domain.model.Bird


package refactoring.catalog.conditional.polymorphism.domain.model;


import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;

import javax.annotation.concurrent.ThreadSafe;


@Value
@ThreadSafe
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
class Bird implements IBird {

    String name;

    Type type;

    int voltage;

    int numberOfCoconuts;

    boolean nailed;

    public PLUMAGE plumage() {
        return this.type.plumage(this);
    }

    public int airSpeedVelocity() {
        return this.type.airSpeedVelocity(this);
    }

}///:~