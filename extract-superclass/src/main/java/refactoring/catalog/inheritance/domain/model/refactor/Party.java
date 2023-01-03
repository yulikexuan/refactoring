//: refactoring.catalog.inheritance.domain.model.refactor.Party


package refactoring.catalog.inheritance.domain.model.refactor;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;


@Getter
@Accessors(fluent = true)
@AllArgsConstructor
abstract class Party {

    private String name;

    public long totalAnnualCost() {
        return this.monthlyCost() * 12;
    }

    public abstract long monthlyCost();

}///:~