//: refactoring.catalog.inheritance.bird.domain.model.EuropeanSwallowDelegate


package refactoring.catalog.inheritance.bird.domain.model;


import lombok.AllArgsConstructor;


@AllArgsConstructor(staticName = "of")
class EuropeanSwallowDelegate implements IBird {

    private final IBird host;

    @Override
    public String name() {
        return this.host.name();
    }

    @Override
    public PlumageType plumage() {
        return this.host.plumage();
    }

    @Override
    public int airSpeedVelocity() {
        return 35;
    }

}///:~