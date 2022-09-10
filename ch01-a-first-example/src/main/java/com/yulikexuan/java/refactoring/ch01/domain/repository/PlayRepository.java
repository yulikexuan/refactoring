package com.yulikexuan.java.refactoring.ch01.domain.repository;


import com.yulikexuan.java.refactoring.ch01.domain.model.Invoice;
import com.yulikexuan.java.refactoring.ch01.domain.model.InvoiceDto;
import com.yulikexuan.java.refactoring.ch01.domain.model.PerformanceDto;
import com.yulikexuan.java.refactoring.ch01.domain.model.Play;
import lombok.NonNull;

import java.util.List;
import java.util.Set;


public sealed interface PlayRepository permits PlayRepositoryImpl {

    Play getPlay(@NonNull final String id);

    Set<Play> getAll();

    static InvoiceDto invoiceDto(@NonNull final Invoice invoice,
                                 @NonNull final PlayRepository playRepository) {

        final String customer = invoice.getCustomer();

        final List<PerformanceDto> perfs = invoice.getPerformances().stream()
                .map(perf -> PerformanceDto.of(
                        perf, playRepository.getPlay(perf.getPlayId())))
                .toList();


        return InvoiceDto.of(customer, perfs);
    }

}