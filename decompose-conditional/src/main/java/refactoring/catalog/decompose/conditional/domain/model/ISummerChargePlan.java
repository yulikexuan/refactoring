//: refactoring.catalog.decompose.conditional.domain.model.ISummerChargePlan


package refactoring.catalog.decompose.conditional.domain.model;


import java.time.LocalDate;


public interface ISummerChargePlan {

    long charge(long quantity, LocalDate aDate);

}///:~