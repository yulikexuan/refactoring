//: refactoring.catalog.encapsulate.collection.domain.model.Person


package refactoring.catalog.encapsulate.collection.domain.model;


import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import lombok.*;
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

    public List<Course> courses() {
        return ImmutableList.copyOf(this.courses);
    }

    public void courses(@NonNull final List<Course> courses) {
        this.courses = Lists.newArrayList(courses);
    }

    public long numberOfCourses() {
        return this.courses.size();
    }

    public void addCourse(@NonNull final Course course) {
        this.courses.add(course);
    }

    public boolean removeCourse(@NonNull final Course course) {
        return this.courses.remove(course);
    }

    public long numberOfAdvancedCourses() {
        return this.courses.stream()
                .filter(Course::isAdvanced)
                .count();
    }

    public void assignBasicCourses(@NonNull final List<String> basicCourseNames) {

        this.courses.addAll(basicCourseNames.stream()
                .map(Course::basic)
                .toList());
    }

    public boolean contains(@NonNull final String courseName) {
        return this.courses.stream()
                .map(Course::name)
                .filter(n -> courseName.equals(n))
                .count() > 0;
    }

}///:~