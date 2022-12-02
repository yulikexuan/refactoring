//: refactoring.catalog.conditional.expression.domain.service.CapitalService


package refactoring.catalog.conditional.expression.domain.service;


import refactoring.catalog.conditional.expression.domain.model.Instrument;


public interface CapitalService {

    long adjustCapital(Instrument instrument);

}///:~