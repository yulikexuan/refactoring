//: refactoring.catalog.move.statements.domain.model.ProfileRenderer


package refactoring.catalog.move.statements.domain.model;


import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.Accessors;


@Value
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
public class ProfileRenderer {

    static final String PERSON_HTML_TEMPLATE =
            "Profile%nName: %s%n-------%n%s%nLocation: %s%n";

    static final String PHOTO_TEMPLATE2 = "Photo Title: %s%nDate: %s%n";

    public String renderPerson(@NonNull final Person person) {
        return String.format(PERSON_HTML_TEMPLATE,
                person.name(),
                this.emitPhotoData2(person.photo()),
                person.photo().location());
    }

    public String emitPhotoData2(@NonNull final Photo photo) {
        return String.format(PHOTO_TEMPLATE2,
                photo.title(), photo.date().toString());
    }

}///:~