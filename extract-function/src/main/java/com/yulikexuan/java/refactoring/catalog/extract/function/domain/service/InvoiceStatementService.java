package com.yulikexuan.java.refactoring.catalog.extract.function.domain.service;


import com.google.common.collect.ImmutableList;
import com.yulikexuan.java.refactoring.catalog.extract.function.domain.model.Invoice;
import com.yulikexuan.java.refactoring.catalog.extract.function.domain.model.InvoiceDto;
import com.yulikexuan.java.refactoring.catalog.extract.function.domain.model.OrderDto;
import lombok.NonNull;

import java.time.format.DateTimeFormatter;
import java.util.List;


public sealed interface InvoiceStatementService permits InvoiceStatementServiceImpl {

    DateTimeFormatter DEFAULT_DATE_TIME_FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd kk:mm:ss");

    String printOwing(InvoiceDto invoice);

    InvoiceDto convertInvoiceToInvoiceDto(Invoice invoice);
}

final class InvoiceStatementServiceImpl implements InvoiceStatementService {

    @Override
    public InvoiceDto convertInvoiceToInvoiceDto(@NonNull final Invoice invoice) {

        List<OrderDto> orders = invoice.getOrders().stream()
                .map(o -> OrderDto.of(o.getAmount()))
                .toList();

        return InvoiceDto.of(invoice.getCustomer(),
                ImmutableList.copyOf(orders), invoice.getDueDate());
    }

    @Override
    public String printOwing(@NonNull final InvoiceDto invoice) {

        final StringBuilder stmtBuilder = new StringBuilder();

        printInvoiceHeader(stmtBuilder);
        printInvoiceDetails(invoice, stmtBuilder);

        return stmtBuilder.toString();
    }

    private void printInvoiceDetails(
            @NonNull final InvoiceDto invoice,
            @NonNull final StringBuilder stmtBuilder) {

        stmtBuilder.append(String.format("name: %s%n", invoice.getCustomer()));
        stmtBuilder.append(String.format("amount: %d%n", invoice.getOutstanding()));
        stmtBuilder.append(String.format("due: %s", invoice.getCurrentDueAsString()));
    }

    private void printInvoiceHeader(
            @NonNull final StringBuilder stmtBuilder) {

        stmtBuilder.append("***********************\r\n");
        stmtBuilder.append("**** Customer Owes ****\r\n");
        stmtBuilder.append("***********************\r\n");
    }

}