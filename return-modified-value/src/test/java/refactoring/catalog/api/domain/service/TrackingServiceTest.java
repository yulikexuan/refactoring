package refactoring.catalog.api.domain.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import refactoring.catalog.api.domain.model.Point;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test class TrackingService - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class TrackingServiceTest {

    private TrackingService trackingService;
    private TrackingServiceRefactor trackingServiceRefactor;

    @BeforeEach
    void setUp() {
    }

    @ParameterizedTest
    @CsvSource({ "10, 12, 15, 11, 14, 17, 16, 11" })
    void able_To_Track_Points(long elevation_0,
                              long elevation_1,
                              long elevation_2,
                              long elevation_3,
                              long elevation_4,
                              long elevation_5,
                              long elevation_6,
                              long expectedTotalAscent) {

        // Given
        final List<Point> points = List.of(Point.of(elevation_0),
                Point.of(elevation_1),
                Point.of(elevation_2),
                Point.of(elevation_3),
                Point.of(elevation_4),
                Point.of(elevation_5),
                Point.of(elevation_6));

        this.trackingService = TrackingService.of(points);

        this.trackingServiceRefactor = TrackingServiceRefactor.of(points);

        // When
        this.trackingService.track();
        long actualTotalAscent = this.trackingService.totalAscent();

        this.trackingServiceRefactor.track();
        long actualTotalAscentRefactor = this.trackingServiceRefactor.totalAscent();

        // Then
        assertThat(actualTotalAscent).isEqualTo(expectedTotalAscent);
        assertThat(actualTotalAscentRefactor).isEqualTo(expectedTotalAscent);
    }

}///:~