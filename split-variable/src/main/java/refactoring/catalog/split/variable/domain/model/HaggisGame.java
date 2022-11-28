//: refactoring.catalog.split.variable.domain.model.Haggis


package refactoring.catalog.split.variable.domain.model;


import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;


@Value
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
public class HaggisGame {

    long primaryForce;

    long secondaryForce;

    long mass;

    long delay;

    public long getDistanceTravelled(final long time) {

        long result = 0;

        long acc = primaryForce / mass;
        long primaryTime = Math.min(time, delay());

        result = 5 * acc * primaryTime * primaryTime / 10;

        long secondaryTime = time - delay;

        if (secondaryTime > 0) {
            long primaryVel = acc * delay;
            acc = (primaryForce() + secondaryForce) / mass;

            result += (primaryVel * secondaryTime) +
                    (5 * acc * secondaryTime * secondaryTime / 10);
        }

        return result;
    }

}///:~