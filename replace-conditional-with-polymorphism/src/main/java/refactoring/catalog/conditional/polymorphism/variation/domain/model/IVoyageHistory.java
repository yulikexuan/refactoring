//: refactoring.catalog.conditional.polymorphism.variation.domain.model.IVoyageHistory


package refactoring.catalog.conditional.polymorphism.variation.domain.model;


public interface IVoyageHistory {

    String name();

    int length();

    int countOfLoss();

    boolean hasDestination(String destination);

}///:~