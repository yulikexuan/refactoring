package com.yulikexuan.java.refactoring.ch01.domain.service;


import com.yulikexuan.java.refactoring.ch01.domain.model.InvoiceDto;
import com.yulikexuan.java.refactoring.ch01.domain.model.PerformanceDto;
import com.yulikexuan.java.refactoring.ch01.domain.repository.PlayRepository;
import lombok.RequiredArgsConstructor;

import static com.yulikexuan.java.refactoring.ch01.domain.service.StatementService.toUSD;


@RequiredArgsConstructor(staticName = "of")
public final class PlainTextStatementService implements StatementService {

    static final String STMT_HEADER_TEMPLATE = "Statement for %s%n";

    private final PlayRepository playRepository;

    @Override
    public String getStatement(InvoiceDto invoiceDto) {

        StringBuilder stmtBuilder = new StringBuilder(
                String.format(STMT_HEADER_TEMPLATE, invoiceDto.getCustomer()));

        // Calc total amount & credits
        for (PerformanceDto perf : invoiceDto.getPerformances()) {
            stmtBuilder.append(String.format(STMT_TEMPLATE,
                    perf.getPlayName(), toUSD(perf.amount()), perf.getAudience()));
        }

        // Printing
        stmtBuilder.append(String.format(
                "Amount owed is %s%n", toUSD(invoiceDto.totalAmount())));
        stmtBuilder.append(String.format(
                "You earned %d credits%n", invoiceDto.totalVolumeCredits()));

        return stmtBuilder.toString();
    }

}