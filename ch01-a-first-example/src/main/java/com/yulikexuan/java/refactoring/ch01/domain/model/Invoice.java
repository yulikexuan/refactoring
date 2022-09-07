package com.yulikexuan.java.refactoring.ch01.domain.model;


import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import lombok.*;

import java.util.List;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class Invoice {

    @NonNull
    private String customer;

    @NonNull
    private List<Performance> performances = Lists.newArrayList();

    public List<Performance> getPerformances() {
        return ImmutableList.copyOf(this.performances);
    }

}