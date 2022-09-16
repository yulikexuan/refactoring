package com.yulikexuan.java.refactoring.catalog.extract.function.domain.model;


import lombok.RequiredArgsConstructor;
import lombok.Value;


@Value
@RequiredArgsConstructor(staticName = "of")
public class OrderDto {

    int amount;
}