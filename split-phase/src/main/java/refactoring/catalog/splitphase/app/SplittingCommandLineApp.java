//: refactoring.catalog.splitphase.app.SplittingCommandLineApp


package refactoring.catalog.splitphase.app;


import com.yulikexuan.java.refactoring.json.JsonObjectConverter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import refactoring.catalog.splitphase.domain.model.Payment;
import refactoring.catalog.splitphase.domain.model.PaymentCountingCommand;

import java.util.stream.Stream;

import static refactoring.catalog.splitphase.domain.model.Payment.Status.READY;


@RequiredArgsConstructor(staticName = "of")
public class SplittingCommandLineApp {

    private final JsonObjectConverter<Payment[]> paymentJsonObjectConverter;

    public long countPayments(@NonNull final PaymentCountingCommand command) {

        Payment[] payments = paymentJsonObjectConverter
                .toObject(command.paymentsJsonData())
                .orElseGet(() -> new Payment[] {});

        return command.isReady() ? countReadyPayments(payments) : payments.length;
    }

    private long countReadyPayments(@NonNull final Payment[] payments) {
        return Stream.of(payments)
                .filter(p -> READY.equals(p.status()))
                .count();
    }


}///:~