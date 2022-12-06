//: refactoring.catalog.conditional.polymorphism.variation.domain.model.voyage


package refactoring.catalog.conditional.polymorphism.variation.domain.model;


import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;

import javax.annotation.concurrent.ThreadSafe;


@Value
@ThreadSafe
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
class Voyage implements IVoyage {

    int length;

    String zone;

    long profit;

}///:~