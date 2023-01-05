//: refactoring.catalog.inheritance.bird.domain.model.NorwegianBlueParrotDelegate


package refactoring.catalog.inheritance.bird.domain.model;


import lombok.AllArgsConstructor;

import static refactoring.catalog.inheritance.bird.domain.model.PlumageType.SCORCHED;


@AllArgsConstructor(staticName = "of")
class NorwegianBlueParrotDelegate implements IBird {

    private final IBird host;

    private PlumageType plumage;

    private final int voltage;

    private final boolean nailed;

    @Override
    public String name() {
        return this.host.name();
    }

    @Override
    public PlumageType plumage() {
        return (this.voltage > 100) ? SCORCHED : this.plumage;
    }

    @Override
    public int airSpeedVelocity() {
        return (this.nailed) ? 0 : 10 + this.voltage / 10;
    }

}///:~