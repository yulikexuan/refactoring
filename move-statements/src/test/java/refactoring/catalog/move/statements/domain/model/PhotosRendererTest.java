package refactoring.catalog.move.statements.domain.model;


import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import static refactoring.catalog.move.statements.domain.model.PhotosRenderer.PHOTO_DATA_TEMPLATE;


@DisplayName("Test class PhotosRenderer- ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class PhotosRendererTest {

    private ProfileRenderer profileRenderer;

    private PhotosRenderer photosRenderer;

    @BeforeEach
    void setUp() {
        this.profileRenderer = ProfileRenderer.of();
        this.photosRenderer = PhotosRenderer.of(this.profileRenderer);
    }

    @Test
    void class_PhotosRenderer_Should_Be_Immutable() {

        // Given
        final String targetLocation = "Quebec";

        final List<Photo> photos = List.of(
                Photo.of(RandomStringUtils.randomAlphanumeric(7),
                        LocalDate.now(), targetLocation),
                Photo.of(RandomStringUtils.randomAlphanumeric(7),
                        LocalDate.now(), targetLocation),
                Photo.of(RandomStringUtils.randomAlphanumeric(7),
                        LocalDate.now(),
                        RandomStringUtils.randomAlphanumeric(17)),
                Photo.of(RandomStringUtils.randomAlphanumeric(7),
                        LocalDate.now(), targetLocation));

        final String expectedPhotosData = String.format(PHOTO_DATA_TEMPLATE,
                targetLocation,
                photos.stream()
                        .filter(p -> targetLocation.equals(p.location()))
                        .map(profileRenderer::emitPhotoData2)
                        .collect(Collectors.joining()));

        // When
        String actualPhotosData = this.photosRenderer.renderPhotosForLocation(
                photos, targetLocation);

        // Then
        assertThat(actualPhotosData).isEqualTo(expectedPhotosData);
        System.out.println(actualPhotosData);
    }

}///:~