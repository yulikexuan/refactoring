package com.yulikexuan.java.refactoring.catalog.extract.function.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class Order {

    private int amount;
}
