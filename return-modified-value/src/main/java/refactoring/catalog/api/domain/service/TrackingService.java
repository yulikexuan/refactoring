//: refactoring.catalog.api.domain.service.TrackingService


package refactoring.catalog.api.domain.service;


import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import refactoring.catalog.api.domain.model.Point;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


@Accessors(fluent = true)
@RequiredArgsConstructor(staticName = "of")
class TrackingService {

    private final List<Point> points;

    private long totalAscent = 0;

    private long totalTime = 0;

    private long totalDistance = 0;

    private long pace = 0;

    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    void track() {

        calculateAscent();
        calculateTime();
        calculateDistance();
        calculatePace();
    }

    void calculateAscent() {
        for (int i = 1; i < points.size(); i++) {
            final long verticalChange =
                    points.get(i).elevation() - points.get(i - 1).elevation();
            totalAscent += (verticalChange > 0) ? verticalChange : 0;
        }
    }

    void calculateTime() {
        this.totalTime = this.random.nextLong(1000, 9999);
    }

    void calculateDistance() {
        totalDistance = this.random.nextLong(10, 99);
    }

    void calculatePace() {
        pace = totalTime / 60 / totalDistance;
    }

    long totalAscent() {
        return this.totalAscent;
    }

}///:~