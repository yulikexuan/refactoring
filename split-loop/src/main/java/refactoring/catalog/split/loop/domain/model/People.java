//: refactoring.catalog.split.loop.domain.model.People


package refactoring.catalog.split.loop.domain.model;


import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.tuple.ImmutablePair;

import javax.annotation.concurrent.ThreadSafe;
import java.util.List;


@Value
@ThreadSafe
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
class People {

    int age;

    long salary;

    static ImmutablePair<Integer, Long> count(@NonNull final List<People> people) {
        return ImmutablePair.of(youngestAge(people), totalSalary(people));
    }

    static int youngestAge(@NonNull final List<People> people) {
        return people.stream()
                .mapToInt(People::age)
                .min()
                .orElse(0);
    }

    static long totalSalary(@NonNull final List<People> people) {
        return people.stream()
                .mapToLong(People::salary)
                .sum();
    }

}///:~