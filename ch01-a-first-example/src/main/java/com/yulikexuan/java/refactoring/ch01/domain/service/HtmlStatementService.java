package com.yulikexuan.java.refactoring.ch01.domain.service;


import com.yulikexuan.java.refactoring.ch01.domain.model.Invoice;
import com.yulikexuan.java.refactoring.ch01.domain.model.InvoiceDto;
import com.yulikexuan.java.refactoring.ch01.domain.model.PerformanceDto;
import com.yulikexuan.java.refactoring.ch01.domain.repository.PlayRepository;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor(staticName = "of")
public final class HtmlStatementService implements StatementService {

    static final String STMT_HEADER_TEMPLATE = "<h1>Statement for %s</h1>";

    static final String STMT_PERF_PLAY_TEMPLATE = "<tr><td>%s</td><td>%d</td>";
    static final String STMT_PERF_AMT_TEMPLATE = "<td>%s</td></tr>";

    static final String STMT_TOTAL_AMT_TEMPLATE =
            "<p>Amount owed is <em>%s</em></p>";

    static final String STMT_TOTAL_CREDITS_TEMPLATE =
            "<p>You earned <em>%s</em> credits</p>";

    private final PlayRepository playRepository;

    @Override
    public String getStatement(InvoiceDto invoiceDto) {

        StringBuilder stmtBuilder = new StringBuilder(
                String.format(STMT_HEADER_TEMPLATE, invoiceDto.getCustomer()));

        stmtBuilder.append("<table>");
        stmtBuilder.append("<tr><th>play</th><th>seats</th><th>cost</th></tr>");

        // Calc total amount & credits
        for (PerformanceDto perf : invoiceDto.getPerformances()) {
            stmtBuilder.append(String.format(STMT_PERF_PLAY_TEMPLATE,
                    perf.getPlayName(), perf.getAudience()));
            stmtBuilder.append(String.format(STMT_PERF_AMT_TEMPLATE,
                    StatementService.toUSD(perf.amount())));
        }

        stmtBuilder.append("</table>");

        // Printing
        stmtBuilder.append(String.format(STMT_TOTAL_AMT_TEMPLATE,
                StatementService.toUSD(invoiceDto.totalAmount())));
        stmtBuilder.append(String.format(STMT_TOTAL_CREDITS_TEMPLATE,
                invoiceDto.totalVolumeCredits()));

        return stmtBuilder.toString();
    }

}