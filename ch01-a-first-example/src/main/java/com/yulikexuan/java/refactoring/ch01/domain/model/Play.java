package com.yulikexuan.java.refactoring.ch01.domain.model;


import lombok.*;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class Play {

    @NonNull
    private String name;

    @NonNull
    private PlayType playType;

}