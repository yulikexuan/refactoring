//: refactoring.catalog.inheritance.bird.domain.model.refactor.BirdRefactor


package refactoring.catalog.inheritance.bird.domain.model.refactor;


import lombok.Getter;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.Accessors;
import refactoring.catalog.inheritance.bird.domain.model.BirdDto;
import refactoring.catalog.inheritance.bird.domain.model.IBird;
import refactoring.catalog.inheritance.bird.domain.model.PlumageType;

import javax.annotation.concurrent.ThreadSafe;
import java.util.Objects;
import java.util.function.BiFunction;


@Value
@ThreadSafe
@Accessors(fluent = true)
public class BirdRefactor implements IBird {

    private final String name;

    private final PlumageType plumage;

    private final IBird speciesDelegate;

    private BirdRefactor(BirdDto data,
                         BiFunction<IBird, BirdDto, IBird> delegateFunc) {

        this.name = data.name();
        this.plumage = data.plumage();

        this.speciesDelegate = delegateFunc.apply(this, data);
    }

    public static BirdRefactor of(@NonNull final BirdDto data) {
        return new BirdRefactor(data, (bird, dto) ->
                IBird.selectSpeciesDelegate(bird, dto));
    }

    @Override
    public PlumageType plumage() {
        return Objects.isNull(speciesDelegate) ?
                this.plumage : this.speciesDelegate.plumage();
    }

    @Override
    public int airSpeedVelocity() {
        return Objects.isNull(speciesDelegate) ?
                0 : this.speciesDelegate.airSpeedVelocity();
    }

//    public static IBird europeanSwallow(@NonNull final BirdDto data) {
//        return new EuropeanSwallowRefactor(data);
//    }
//
//    public static IBird africanSwallowRefactor(@NonNull final BirdDto data) {
//        return new AfricanSwallowRefactor(data);
//    }
//
//    public static IBird norwegianBlueParrotRefactor(@NonNull final BirdDto data) {
//        return new NorwegianBlueParrotRefactor(data);
//    }

}

//final class EuropeanSwallowRefactor extends BirdRefactor {
//
//    EuropeanSwallowRefactor(@NonNull final BirdDto data) {
//        super(data);
//    }
//
//    @Override
//    public int airSpeedVelocity() {
//        return 35;
//    }
//
//}
//
//final class AfricanSwallowRefactor extends BirdRefactor {
//
//    private final int numberOfCoconuts;
//
//    AfricanSwallowRefactor(@NonNull final BirdDto data) {
//        super(data);
//        this.numberOfCoconuts = data.numberOfCoconuts();
//    }
//
//    @Override
//    public int airSpeedVelocity() {
//        return 40 - 2 * this.numberOfCoconuts;
//    }
//
//}
//
//final class NorwegianBlueParrotRefactor  extends BirdRefactor {
//
//    private final int voltage;
//
//    private final boolean nailed;
//
//    NorwegianBlueParrotRefactor(@NonNull final BirdDto data) {
//
//        super(data);
//        this.voltage = data.voltage();
//        this.nailed = data.nailed();
//    }
//
//    @Override
//    public int airSpeedVelocity() {
//        return (this.nailed) ? 0 : 10 + this.voltage / 10;
//    }
//
//    @Override
//    public PlumageType plumage() {
//        return (this.voltage > 100) ? SCORCHED : this.plumage;
//    }
//
//}

///:~