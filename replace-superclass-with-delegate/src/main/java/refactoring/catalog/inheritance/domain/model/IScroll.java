//: refactoring.catalog.inheritance.domain.model.IScroll


package refactoring.catalog.inheritance.domain.model;


import java.time.LocalDate;


public interface IScroll extends ICatalog {

    LocalDate dateLastCleaned();

    boolean needsCleaning(LocalDate targetDate);

    long daysSinceLastCleaning(LocalDate targetDate);

}///:~