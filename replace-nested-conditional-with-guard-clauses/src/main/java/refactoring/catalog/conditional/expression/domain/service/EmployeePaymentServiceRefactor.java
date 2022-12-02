//: refactoring.catalog.conditional.expression.domain.service.EmployeePaymentServiceRefactor


package refactoring.catalog.conditional.expression.domain.service;


import lombok.AllArgsConstructor;
import lombok.NonNull;
import refactoring.catalog.conditional.expression.domain.model.Employee;
import refactoring.catalog.conditional.expression.domain.model.Payment;

import javax.annotation.concurrent.ThreadSafe;

import static refactoring.catalog.conditional.expression.domain.model.Payment.State.*;


@ThreadSafe
@AllArgsConstructor(staticName = "of")
class EmployeePaymentServiceRefactor implements IEmployeePaymentService {

    private final FinancingService financingService;

    @Override
    public Payment payAmount(@NonNull Employee employee) {
        if (employee.separated()) return Payment.of(0, SEP);
        if (employee.retired()) return Payment.of(0, RET);

        return Payment.of(financingService.computation(), EMPLOYED);
    }

}///:~