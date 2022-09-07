package com.yulikexuan.java.refactoring.ch01.domain.model;


import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import lombok.Value;

import java.util.List;


@Value
public class InvoiceDto {

    String customer;

    ImmutableList<PerformanceDto> performances;

    private InvoiceDto(String customer, ImmutableList<PerformanceDto> performances) {
        this.customer = customer;
        this.performances = performances;
    }

    public static InvoiceDto of(
            @NonNull final String customer,
            @NonNull final List<PerformanceDto> performances) {

        return new InvoiceDto(customer, ImmutableList.copyOf(performances));
    }

    public int totalAmount() {
        return this.performances.stream()
                .map(PerformanceDto::amount)
                .reduce(0, Integer::sum);
    }

    public int totalVolumeCredits() {
        return this.performances.stream()
                .map(PerformanceDto::volumeCredits)
                .reduce(0, Integer::sum);
    }

}