//: refactoring.catalog.move.statements.domain.model.PhotosRenderer


package refactoring.catalog.move.statements.domain.model;


import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.stream.Collectors;


@Value
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
public class PhotosRenderer {

    static final String PHOTO_DATA_TEMPLATE = "Photo Location: %s%n-------%n%s%n";

    ProfileRenderer profileRenderer;

    public String renderPhotosForLocation(@NonNull final List<Photo> photos,
                                          @NonNull final String location) {

        String photoData = photos.stream()
                .filter(p -> location.equals(p.location()))
                .map(profileRenderer::emitPhotoData2)
                .collect(Collectors.joining());

        return String.format(PHOTO_DATA_TEMPLATE, location, photoData);
    }

}///:~