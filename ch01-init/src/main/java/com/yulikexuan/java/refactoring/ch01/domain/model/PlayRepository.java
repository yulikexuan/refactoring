package com.yulikexuan.java.refactoring.ch01.domain.model;


import lombok.*;

import java.util.Map;
import java.util.Objects;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class PlayRepository {

    private Map<String, Play> plays;

    public Play getPlay(@NonNull final String key) {

        if (Objects.isNull(plays)) {
            return null;
        }

        return plays.get(key);
    }

}
