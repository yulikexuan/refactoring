package com.yulikexuan.java.refactoring.ch01.domain.service;


import com.yulikexuan.java.refactoring.ch01.domain.model.Invoice;
import com.yulikexuan.java.refactoring.ch01.domain.model.InvoiceDto;
import com.yulikexuan.java.refactoring.ch01.domain.repository.PlayRepository;
import lombok.NonNull;

import java.text.NumberFormat;
import java.util.Locale;


public sealed interface StatementService
        permits PlainTextStatementService, HtmlStatementService {

    String STMT_TEMPLATE = "  - %s : %s (%d seats)%n";
    NumberFormat USD_FORMATTER = NumberFormat.getCurrencyInstance(Locale.US);

    String getStatement(InvoiceDto invoice);

    static StatementService plainTextStatementService(
            @NonNull final PlayRepository playRepository) {

        return PlainTextStatementService.of(playRepository);
    }

    static StatementService htmlStatementService(
            @NonNull final PlayRepository playRepository) {

        return HtmlStatementService.of(playRepository);
    }

    static String toUSD(final int amount) {
        return USD_FORMATTER.format(amount / 100);
    }

    static InvoiceDto convertInvoiceToDto(
            @NonNull final Invoice invoice,
            @NonNull final PlayRepository playRepository) {

        return PlayRepository.invoiceDto(invoice, playRepository);
    }

}