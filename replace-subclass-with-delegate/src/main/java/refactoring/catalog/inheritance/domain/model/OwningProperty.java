//: refactoring.catalog.inheritance.domain.model.OwningProperty


package refactoring.catalog.inheritance.domain.model;


public interface OwningProperty {

    enum Property {
        TALKBACK, DINNER;
    }

    boolean hasOwnProperty(Property property);

}///:~