package refactoring.catalog.parameter.domain.model;


import lombok.AllArgsConstructor;
import lombok.Value;


@Value
@AllArgsConstructor
public class NumberRange {

    int min;
    int max;

    public static NumberRange of(final int min, final int max) {
        if (min >= max) {
            String errMsg = String.format(
                    ">>> [%s ERROR] - min should be less than max",
                    NumberRange.class.getSimpleName());
            throw new IllegalArgumentException(errMsg);
        }
        return new NumberRange(min, max);
    }

    public int min() {
        return this.min;
    }

    public int max() {
        return this.max;
    }

}
