//: refactoring.catalog.api.domain.service.IShippingService


package refactoring.catalog.api.domain.service;


import lombok.NonNull;
import refactoring.catalog.api.domain.model.Order;
import refactoring.catalog.api.domain.model.OrderError;

import java.util.List;


public interface IShippingService {

    void shipping(@NonNull Order order);

    List<OrderError> errorList();

}///:~