package refactoring.catalog.move.statements.domain.model;


import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import static org.mutabilitydetector.unittesting.MutabilityAssert.assertImmutable;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test refactoring.catalog.move.statements.domain.model.ProfileRenderer- ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class ProfileRendererTest {

    private Photo photo;

    private Person person;

    private String personName;

    private String photoTitle;

    private String photoLocation;

    private LocalDate photoDate;

    private ProfileRenderer profileRenderer;

    @BeforeEach
    void setUp() {

        this.photoTitle = RandomStringUtils.randomAlphanumeric(7);
        this.photoLocation = RandomStringUtils.randomAlphanumeric(17);
        this.photoDate = LocalDate.now();
        this.photo = Photo.of(photoTitle, photoDate, photoLocation);

        this.personName = RandomStringUtils.randomAlphabetic(5);
        this.person = Person.of(this.personName, this.photo);

        this.profileRenderer = ProfileRenderer.of(this.person);
    }

    @Test
    void class_Person_Should_Be_Immutable() {
        assertImmutable(Person.class);
    }

    @Test
    void class_Photo_Should_Be_Immutable() {
        assertImmutable(Photo.class);
    }

    @Test
    void class_ProfileRenderer_Should_Be_Immutable() {
        assertImmutable(ProfileRenderer.class);
    }

    @Test
    void able_To_Emit_Photo_Data() {

        // Given
        String expectedPhotoData = String.format(
                ProfileRenderer.PHOTO_DATA_TEMPLATE,
                this.photo.location(), this.photo.date().toString());

        // When
        String actualPhotoData = this.profileRenderer.emitPhotoData();

        // Then
        assertThat(actualPhotoData).isEqualTo(expectedPhotoData);
    }

    @Test
    void able_To_Render_Photo_In_HTML() {

        // Given
        String expectedPhotoHtml = String.format(ProfileRenderer.PHOTO_HTML_TEMPLATE,
                this.photo.title(), this.profileRenderer.emitPhotoData());
        // When
        String actualPhotoHtml = this.profileRenderer.renderPhotoHtml();

        // Then
        assertThat(actualPhotoHtml).isEqualTo(expectedPhotoHtml);
    }

    @Test
    void able_To_Render_Person_Profile() {

        // Given
        String expectedProfileHtml = String.format(
                ProfileRenderer.PERSON_HTML_TEMPLATE,
                this.person.name(),
                this.photo.title(),
                this.profileRenderer.emitPhotoData());

        // When
        String actualProfileHtml = this.profileRenderer.renderPerson();

        // Then
        assertThat(actualProfileHtml).isEqualTo(expectedProfileHtml);
    }

}///:~