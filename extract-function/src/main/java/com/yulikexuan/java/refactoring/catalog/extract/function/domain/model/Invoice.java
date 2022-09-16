package com.yulikexuan.java.refactoring.catalog.extract.function.domain.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class Invoice {

    public static final String ACTION_TIME_FORMAT = "yyyy-MM-dd HH:mm:ssXXX";

    private String customer;
    private List<Order> orders;

    @JsonFormat(pattern = ACTION_TIME_FORMAT, shape = JsonFormat.Shape.STRING)
    private OffsetDateTime dueDate;
}
