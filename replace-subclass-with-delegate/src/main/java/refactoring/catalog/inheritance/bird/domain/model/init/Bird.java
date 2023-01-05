//: refactoring.catalog.inheritance.bird.domain.model.init.Bird


package refactoring.catalog.inheritance.bird.domain.model.init;


import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.Accessors;
import refactoring.catalog.inheritance.bird.domain.model.BirdDto;
import refactoring.catalog.inheritance.bird.domain.model.IBird;
import refactoring.catalog.inheritance.bird.domain.model.PlumageType;

import static refactoring.catalog.inheritance.bird.domain.model.PlumageType.*;


@Getter
@Accessors(fluent = true)
class Bird implements IBird {

    final String name;

    final PlumageType plumage;

    Bird(@NonNull final BirdDto data) {
        this.name = data.name();
        this.plumage = data.plumage();
    }

}

final class EuropeanSwallow extends Bird {

    EuropeanSwallow(@NonNull final BirdDto data) {
        super(data);
    }

    @Override
    public int airSpeedVelocity() {
        return 35;
    }

}

final class AfricanSwallow extends Bird {

    private final int numberOfCoconuts;

    AfricanSwallow(@NonNull final BirdDto data) {
        super(data);
        this.numberOfCoconuts = data.numberOfCoconuts();
    }

    @Override
    public int airSpeedVelocity() {
        return 40 - 2 * this.numberOfCoconuts;
    }

}

final class NorwegianBlueParrot  extends Bird {

    private final int voltage;

    private final boolean nailed;

    NorwegianBlueParrot(@NonNull final BirdDto data) {

        super(data);
        this.voltage = data.voltage();
        this.nailed = data.nailed();
    }

    @Override
    public int airSpeedVelocity() {
        return (this.nailed) ? 0 : 10 + this.voltage / 10;
    }

    @Override
    public PlumageType plumage() {
        return (this.voltage > 100) ? SCORCHED : this.plumage;
    }

}

///:~