package refactoring.extractfunc.domain.model;


import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import lombok.Value;

import java.time.OffsetDateTime;
import java.util.List;

import static java.time.format.DateTimeFormatter.ofPattern;


@Value
public class InvoiceDto {

    static final int DUE_DAYS = 30;

    String customer;

    ImmutableList<OrderDto> orders;

    OffsetDateTime dueDate;

    private InvoiceDto(String customer,
                       ImmutableList<OrderDto> orders,
                       OffsetDateTime dueDate) {

        this.customer = customer;
        this.orders = orders;
        this.dueDate = dueDate;
    }

    public static InvoiceDto of(@NonNull final String customer,
                                @NonNull final List<OrderDto> orders,
                                @NonNull final OffsetDateTime dueDate) {

        return new InvoiceDto(customer, ImmutableList.copyOf(orders), dueDate);
    }

    public int getOutstanding() {
        return this.orders.stream()
                .map(OrderDto::getAmount)
                .reduce(0, Integer::sum);
    }

    public String getCurrentDueAsString() {
        return this.dueDate.plusDays(DUE_DAYS)
                .format(ofPattern(Invoice.ACTION_TIME_FORMAT));
    }

}