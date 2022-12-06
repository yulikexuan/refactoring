//: refactoring.catalog.conditional.polymorphism.domain.model.IBird


package refactoring.catalog.conditional.polymorphism.domain.model;


import lombok.NonNull;

import java.util.function.Function;

import static refactoring.catalog.conditional.polymorphism.domain.model.IBird.PLUMAGE.*;


public interface IBird {

    public enum Type {

        EUROPEAN_SWALLOW(bird -> AVERAGE, bird -> 35),

        AFRICAN_SWALLOW(
                bird -> (bird.numberOfCoconuts() > 2) ? TIRED : AVERAGE,
                bird -> 40 - 2 * bird.numberOfCoconuts()),

        NORWEGIAN_BLUE_PARROT(
                bird -> (bird.voltage() > 100) ? SCORCHED : BEAUTIFUL,
                bird -> (bird.nailed()) ? 0 : 10 + bird.voltage() / 10),

        PEACOCK(bird -> UNKNOWN, bird -> -1);

        private final Function<IBird, PLUMAGE> plumageFunc;

        private final Function<IBird, Integer> airSpeedVelocityFunc;

        Type(@NonNull final Function<IBird, PLUMAGE> plumageFunc,
             @NonNull final Function<IBird, Integer> airSpeedVelocityFunc) {

            this.plumageFunc = plumageFunc;
            this.airSpeedVelocityFunc = airSpeedVelocityFunc;
        }

        public PLUMAGE plumage(@NonNull final IBird bird) {
            return this.plumageFunc.apply(bird);
        }

        public int airSpeedVelocity(@NonNull final IBird bird) {
            return this.airSpeedVelocityFunc.apply(bird);
        }

    } //: End of enum IBird.Type

    public enum PLUMAGE {
        AVERAGE, TIRED, SCORCHED, BEAUTIFUL, UNKNOWN;
    }

    String name();

    Type type();

    int voltage();

    int numberOfCoconuts();

    boolean nailed();

    PLUMAGE plumage();

    int airSpeedVelocity();

}///:~