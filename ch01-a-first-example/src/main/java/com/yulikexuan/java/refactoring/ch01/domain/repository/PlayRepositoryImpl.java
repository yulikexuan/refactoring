package com.yulikexuan.java.refactoring.ch01.domain.repository;


import com.google.common.collect.ImmutableSet;
import com.yulikexuan.java.refactoring.ch01.domain.model.Play;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


@ToString
@EqualsAndHashCode
@NoArgsConstructor
public final class PlayRepositoryImpl implements PlayRepository {

    private Map<String, Play> plays;

    public Play getPlay(@NonNull final String id) {

        if (Objects.isNull(plays)) {
            return null;
        }

        return plays.get(id);
    }

    public Set<Play> getAll() {

        if (Objects.isNull(plays)) {
            Set.of();
        }

        return ImmutableSet.copyOf(this.plays.values());
    }

    public void setPlays(@NonNull final Map<String, Play> plays) {
        this.plays = new ConcurrentHashMap<>(plays);
    }

}