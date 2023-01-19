package com.yulikexuan.java.refactoring.ch01.domain.service;


import com.yulikexuan.java.refactoring.ch01.domain.model.Invoice;
import com.yulikexuan.java.refactoring.ch01.domain.model.Performance;
import com.yulikexuan.java.refactoring.ch01.domain.model.Play;
import com.yulikexuan.java.refactoring.ch01.domain.model.PlayRepository;
import lombok.NonNull;

import java.text.NumberFormat;
import java.util.Locale;

import static com.yulikexuan.java.refactoring.ch01.domain.model.PlayType.COMEDY;


public sealed interface StatementService permits StatementServiceImpl {

    String getStatement(Invoice invoice, PlayRepository playRepo);

    static StatementService of() {
        return new StatementServiceImpl();
    }

}

final class StatementServiceImpl implements StatementService {

    static final String STMT_TEMPLATE = "  - %s : %s (%d seats)%n";

    @Override
    public String getStatement(
            @NonNull final Invoice invoice,
            @NonNull final PlayRepository playRepo) {

        final String customer = invoice.getCustomer();

        int totalAmount = 0;
        int volumeCredits = 0;

        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        StringBuilder stmtBuilder = new StringBuilder();
        stmtBuilder.append(String.format("Statement for %s%n", customer));

        for (Performance perf : invoice.getPerformance()) {

            final Play play = playRepo.getPlay(perf.getPlayId());
            int thisAmount = 0;
            final int audience = perf.getAudience();

            thisAmount = switch (play.getPlayType()) {
                case TRAGEDY -> (audience > 30) ?
                        40000 + 1000 * (audience - 30) : 40000;
                case COMEDY -> (audience > 20) ?
                        (30000 + 10000 + 500 * (audience - 20)) + 300 * audience :
                        30000 + 300 * audience;
            };

            // add volume credits
            volumeCredits += Math.max(audience - 30, 0);

            // add extra credit for every ten comedy attendees
            if (COMEDY == play.getPlayType()) {
                volumeCredits += Math.floor(audience / 5);
            }

            // print line for this order
            stmtBuilder.append(String.format(STMT_TEMPLATE, play.getName(),
                    formatter.format(thisAmount/100), audience));

            totalAmount += thisAmount;
        }

        stmtBuilder.append(String.format("Amount owed is %s%n",
                formatter.format(totalAmount / 100)));
        stmtBuilder.append(String.format("You earned %d credits%n",
                volumeCredits));

        return stmtBuilder.toString();
    }

}