//: refactoring.catalog.api.domain.service.TrackingServiceRefactor


package refactoring.catalog.api.domain.service;


import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import refactoring.catalog.api.domain.model.Point;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


@Accessors(fluent = true)
@RequiredArgsConstructor(staticName = "of")
class TrackingServiceRefactor {

    private final List<Point> points;

    private long totalAscent = 0;

    private long totalTime = 0;

    private long totalDistance = 0;

    private long pace = 0;

    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    void track() {

        this.totalAscent = calculateAscent();
        this.totalTime = calculateTime();
        this.totalDistance = calculateDistance();
        this.pace = calculatePace();
    }

    long calculateAscent() {

        long totalAscent = 0;

        for (int i = 1; i < points.size(); i++) {
            final long verticalChange =
                    points.get(i).elevation() - points.get(i - 1).elevation();
            totalAscent += (verticalChange > 0) ? verticalChange : 0;
        }

        return totalAscent;
    }

    long calculateTime() {
        return this.random.nextLong(1000, 9999);
    }

    long calculateDistance() {
        return this.random.nextLong(10, 99);
    }

    long calculatePace() {
        return totalTime / 60 / totalDistance;
    }

    long totalAscent() {
        return this.totalAscent;
    }

}///:~