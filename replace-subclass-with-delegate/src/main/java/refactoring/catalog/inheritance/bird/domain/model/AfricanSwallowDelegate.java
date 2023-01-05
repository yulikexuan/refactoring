//: refactoring.catalog.inheritance.bird.domain.model.AfricanSwallowRefactorDelegate


package refactoring.catalog.inheritance.bird.domain.model;


import lombok.AllArgsConstructor;


@AllArgsConstructor(staticName = "of")
class AfricanSwallowDelegate implements IBird {

    private final IBird host;

    private final int numberOfCoconuts;

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
        return 40 - 2 * this.numberOfCoconuts;
    }

}///:~