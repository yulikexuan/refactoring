//: refactoring.catalog.conditional.expression.domain.service.EmployeePaymentService


package refactoring.catalog.conditional.expression.domain.service;


import static refactoring.catalog.conditional.expression.domain.model.Payment.State.*;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import refactoring.catalog.conditional.expression.domain.model.Employee;
import refactoring.catalog.conditional.expression.domain.model.Payment;

import javax.annotation.concurrent.ThreadSafe;


@ThreadSafe
@AllArgsConstructor(staticName = "of")
class EmployeePaymentServiceInit implements IEmployeePaymentService {

    private final FinancingService financingService;

    @Override
    public Payment payAmount(@NonNull final Employee employee) {

        Payment result = null;

        if (employee.separated()) {
            result = Payment.of(0, SEP);
        } else {
            if (employee.retired()) {
                result = Payment.of(0, RET);
            } else {
                result = Payment.of(financingService.computation(), EMPLOYED);
            }
        }

        return result;
    }

}///:~