//: refactoring.catalog.api.domain.model.IHeatingPlan


package refactoring.catalog.api.domain.model;


public interface IHeatingPlan {

    int max();

    int min();

    int targetTemperature(final int selectedTemperature);

}///:~