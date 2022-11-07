package refactoring.catalog.encapsulate.collection.domain.model;


import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.Accessors;

import javax.annotation.concurrent.Immutable;


public sealed interface Course {

    String name();

    boolean isAdvanced();

    static Course of(@NonNull final String name, final boolean isAdvanced) {
        return CourseImpl.of(name, isAdvanced);
    }

    static Course basic(@NonNull final String name) {
        return CourseImpl.of(name, false);
    }

}

@Value
@Immutable
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
class CourseImpl implements Course {

    String name;

    boolean isAdvanced;

}