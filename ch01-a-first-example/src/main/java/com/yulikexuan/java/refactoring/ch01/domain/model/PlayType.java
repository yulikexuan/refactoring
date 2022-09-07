package com.yulikexuan.java.refactoring.ch01.domain.model;


import java.util.function.IntUnaryOperator;


public enum PlayType implements IPlayType {

    TRAGEDY(PlayType::calcTragedyAmount, PlayType::calcVolumeCredits),
    COMEDY(PlayType::calcComedyAmount, PlayType::calcComedyVolumeCredits);

    private final IntUnaryOperator calcAmount;
    private final IntUnaryOperator calcVolumeCredits;

    PlayType(IntUnaryOperator calcAmount, IntUnaryOperator calcVolumeCredits) {
        this.calcAmount = calcAmount;
        this.calcVolumeCredits = calcVolumeCredits;
    }

    @Override
    public int amount(final int audience) {
        return this.calcAmount.applyAsInt(audience);
    }

    @Override
    public int volumeCredits(int audience) {
        return this.calcVolumeCredits.applyAsInt(audience);
    }

    private static int calcTragedyAmount(int audience) {
        return (audience > 30) ? 40000 + 1000 * (audience - 30) : 40000;
    }

    private static int calcComedyAmount(int audience) {
        return (audience > 20) ?
                (30000 + 10000 + 500 * (audience - 20)) + 300 * audience :
                30000 + 300 * audience;
    }

    private static int calcVolumeCredits(int audience) {
        return Math.max(audience - 30, 0);
    }

    private static int calcComedyVolumeCredits(int audience) {
        return (int) (calcVolumeCredits(audience) + Math.floor(audience / 5));
    }

}