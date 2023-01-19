package com.yulikexuan.java.refactoring.ch01.domain.model;


import lombok.*;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class Performance {

    @NonNull
    private String playId;

    private int audience;

}