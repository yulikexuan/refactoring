//: refactoring.catalog.slide.statements.domain.service.ChargeService


package refactoring.catalog.slide.statements.domain.service;


import javax.annotation.concurrent.ThreadSafe;


@ThreadSafe
public interface ChargeService {

    long chargeOrder(long charge);

}///:~