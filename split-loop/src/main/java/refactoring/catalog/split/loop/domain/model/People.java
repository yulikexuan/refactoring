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

        int youngest = people.size() > 0 ? people.get(0).age : Integer.MAX_VALUE;

        long totalSalary = 0;

        for (People p : people) {
            if (p.age < youngest) {
                youngest = p.age;
            }
            totalSalary += p.salary;
        }

        return ImmutablePair.of(youngest, totalSalary);
    }

}///:~