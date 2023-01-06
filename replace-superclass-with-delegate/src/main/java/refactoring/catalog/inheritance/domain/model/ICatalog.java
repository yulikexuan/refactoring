//: refactoring.catalog.inheritance.domain.model.Catalog


package refactoring.catalog.inheritance.domain.model;


import java.util.List;


public interface ICatalog {

    int id();

    String title();

    List<String> tags();

    boolean hasTag(String tag);

}///:~