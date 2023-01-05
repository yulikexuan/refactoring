//: refactoring.catalog.inheritance.bird.domain.model.IBird


package refactoring.catalog.inheritance.bird.domain.model;


import lombok.NonNull;
import refactoring.catalog.inheritance.bird.domain.model.refactor.BirdRefactor;


public interface IBird {

    String name();

    PlumageType plumage();

    default int airSpeedVelocity() {
        return 0;
    }

    static IBird of(@NonNull final BirdDto data) {
        return BirdRefactor.of(data);
    }

    static String className(@NonNull final IBird bird) {
        return bird.getClass().getSimpleName();
    }

    static IBird selectSpeciesDelegate(@NonNull final IBird bird,
                                       @NonNull final BirdDto data) {

        final PlumageType plumage = bird.plumage();

        return switch (plumage) {
            case EUROPEAN_SWALLOW -> EuropeanSwallowDelegate.of(bird);
            case AFRICAN_SWALLOW -> AfricanSwallowDelegate.of(
                    bird, data.numberOfCoconuts());
            case NORWEGIAN_BLUE_PARROT ->
                    NorwegianBlueParrotDelegate.of(
                            bird, plumage, data.voltage(), data.nailed());
            default -> null;
        };
    }

}///:~