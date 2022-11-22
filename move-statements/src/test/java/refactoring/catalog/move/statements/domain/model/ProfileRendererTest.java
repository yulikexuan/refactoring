package refactoring.catalog.move.statements.domain.model;


import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static refactoring.catalog.move.statements.domain.model.ProfileRenderer.*;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import static org.mutabilitydetector.unittesting.MutabilityAssert.assertImmutable;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test class ProfileRenderer - ")
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

        this.profileRenderer = ProfileRenderer.of();
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
        String expectedPhotoData = String.format(PHOTO_TEMPLATE2,
                this.photo.title(),
                this.photo.date().toString());

        // When
        String actualPhotoData = this.profileRenderer.emitPhotoData2(this.photo);

        // Then
        assertThat(actualPhotoData).isEqualTo(expectedPhotoData);
    }

    @Test
    void able_To_Render_Person_Profile() {

        // Given
        String expectedProfileHtml = String.format(PERSON_HTML_TEMPLATE,
                this.person.name(),
                this.profileRenderer.emitPhotoData2(this.photo),
                this.photo.location());

        // When
        String actualProfileHtml = this.profileRenderer.renderPerson(this.person);

        // Then
        assertThat(actualProfileHtml).isEqualTo(expectedProfileHtml);
    }

}///:~