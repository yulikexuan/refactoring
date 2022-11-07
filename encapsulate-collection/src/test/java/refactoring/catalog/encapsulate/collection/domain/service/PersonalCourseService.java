package refactoring.catalog.encapsulate.collection.domain.service;


import lombok.AllArgsConstructor;
import lombok.NonNull;
import refactoring.catalog.encapsulate.collection.domain.model.Course;
import refactoring.catalog.encapsulate.collection.domain.model.Person;

import java.util.List;


public interface PersonalCourseService {

    long numberOfCourses();
    long numberOfAdvancedCourses();

    void assignBasicCourses(List<String> basicCourseNames);

}


@AllArgsConstructor(staticName = "of")
final class PersonalCourseServiceImpl implements PersonalCourseService {

    @NonNull
    private final Person person;

    @Override
    public long numberOfCourses() {
        return this.person.numberOfCourses();
    }

    @Override
    public long numberOfAdvancedCourses() {
        return this.person.courses().stream()
                .filter(Course::isAdvanced)
                .count();
    }

    @Override
    public void assignBasicCourses(@NonNull final List<String> basicCourseNames) {

        this.person.courses(basicCourseNames.stream()
                .map(n -> Course.of(n, false))
                .toList());
    }

}