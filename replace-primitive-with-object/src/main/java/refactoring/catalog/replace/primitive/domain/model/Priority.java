package refactoring.catalog.replace.primitive.domain.model;


import lombok.NonNull;
import lombok.experimental.Accessors;


@Accessors(fluent = true)
public enum Priority {

    RUSH(0), HIGH(10), NORMAL(20), LOW(30);

    private final int weight;

    Priority(int weight) {
        this.weight = weight;
    }

    public boolean lowerThan(@NonNull final Priority priority) {
        return this.weight > priority.weight;
    }

    public boolean higherThan(@NonNull final Priority priority) {
        return this.weight < priority.weight;
    }

}