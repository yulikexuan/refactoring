package com.yulikexuan.java.refactoring.ch01.domain.model;


import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;


@Value
@AllArgsConstructor(staticName = "of")
public class PerformanceDto {

    String playId;
    String playName;
    PlayType playType;
    int audience;

    public static PerformanceDto of(
            @NonNull final Performance performance,
            @NonNull final Play play) {

        return PerformanceDto.of(
                performance.getPlayId(),
                play.getName(),
                play.getPlayType(),
                performance.getAudience());
    }

    public int amount() {
        return this.playType.amount(this.audience);
    }

    public int volumeCredits() {
        return this.playType.volumeCredits(this.audience);
    }

}