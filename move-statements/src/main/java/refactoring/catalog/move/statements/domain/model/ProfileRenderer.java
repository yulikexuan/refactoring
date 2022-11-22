//: refactoring.catalog.move.statements.domain.model.ProfileRenderer


package refactoring.catalog.move.statements.domain.model;


import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;


@Value
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
public class ProfileRenderer {

    static final String PHOTO_DATA_TEMPLATE = "Location: %s%nDate: %s%n";
    static final String PHOTO_HTML_TEMPLATE = "Photo Title: %s%n%s%n";

    static final String PERSON_HTML_TEMPLATE =
            "Profile%nName: %s%n-------%nPhoto: %nTitle: %s%n%s%n";

    Person person;

    String emitPhotoData() {
        return String.format(PHOTO_DATA_TEMPLATE,
                this.person.photo().location(),
                this.person.photo().date().toString());
    }

    String renderPhotoHtml() {
        return String.format(PHOTO_HTML_TEMPLATE,
                this.person.photo().title(),
                this.emitPhotoData());
    }

    public String renderPerson() {

        return String.format(PERSON_HTML_TEMPLATE,
                this.person.name(),
                this.person.photo().title(),
                this.emitPhotoData());
    }

}///:~