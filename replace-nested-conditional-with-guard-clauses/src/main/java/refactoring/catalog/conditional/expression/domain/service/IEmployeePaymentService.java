//: refactoring.catalog.conditional.expression.domain.service.IEmployeePaymentService


package refactoring.catalog.conditional.expression.domain.service;


import lombok.NonNull;
import refactoring.catalog.conditional.expression.domain.model.Employee;
import refactoring.catalog.conditional.expression.domain.model.Payment;


public interface IEmployeePaymentService {

    Payment payAmount(@NonNull final Employee employee);

}///:~