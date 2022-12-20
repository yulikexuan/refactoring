//: refactoring.catalog.api.domain.service.ChargeService


package refactoring.catalog.api.domain.service;


import lombok.NonNull;
import refactoring.catalog.api.domain.model.*;


class ChargeService {

    long charge(@NonNull final Customer customer,
                @NonNull final Usage usage,
                @NonNull final Provider provider) {

//        ChargeCalculationCommand command = ChargeCalculationCommand.of(
//                customer, usage, provider);

        long baseCharge = customer.baseRate() * usage.amount() / 100;
        return baseCharge + provider.connectionCharge();

//        return command.execute();
    }

}///:~