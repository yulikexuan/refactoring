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

    long primaryAcc() {
        return primaryForce / mass;
    }


    long primaryVel() {
        return primaryAcc() * delay;
    }

    long fullAcc() {
        return (primaryForce + secondaryForce) / mass;
    }

    long primaryDistance() {
        final long primaryAcc = primaryAcc();
        final long primaryTime = delay;
        return calcDistance(primaryAcc, primaryTime);
    }

    public long fullDistance(final long time) {

        long result = primaryDistance();
        final long secondaryTime = time - delay;

        if (secondaryTime > 0) {
            result += (primaryVel() * secondaryTime) +
                    calcDistance(fullAcc(), secondaryTime);
        }

        return result;
    }

    static long calcDistance(final long acc, final long time) {
        return 5 * acc * time * time / 10;
    }

}///:~
