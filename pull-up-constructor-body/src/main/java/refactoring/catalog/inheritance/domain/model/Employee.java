//: refactoring.catalog.inheritance.domain.model.Employee


package refactoring.catalog.inheritance.domain.model;


abstract class Employee {

    private String name;

    Employee(String name) {
        this.name = name;
    }

    public String name() {
        return this.name;
    }

    abstract boolean isPrivileged();

    void assignCar() {}

    public void finishConstruction() {
        if (isPrivileged()) assignCar();
    }
}


class Manager extends Employee {

    private int grade;

    Manager(String name, int grade) {

        super(name);
        this.grade = grade;
        finishConstruction();
    }

    public boolean isPrivileged() {
        return this.grade > 4;
    }

}

class ManagerRefactor extends Employee {

    private int grade;

    ManagerRefactor(String name, int grade) {

        super(name);
        this.grade = grade;
        finishConstruction();
    }

    public boolean isPrivileged() {
        return this.grade > 6;
    }

}

///:~