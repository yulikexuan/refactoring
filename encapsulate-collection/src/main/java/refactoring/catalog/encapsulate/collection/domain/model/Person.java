//: refactoring.catalog.encapsulate.collection.domain.model.Person


package refactoring.catalog.encapsulate.collection.domain.model;


import com.google.common.collect.Lists;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;


@Getter
@ToString
@EqualsAndHashCode
@Accessors(fluent = true)
@RequiredArgsConstructor(staticName = "of")
public class Person {

    private final String name;
    private List<Course> courses = Lists.newArrayList();

    public void courses(List<Course> courses) {
        this.courses = courses;
    }

    public long numberOfCourses() {
        return this.courses.size();
    }

}///:~