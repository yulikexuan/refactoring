//: refactoring.catalog.replace.loop.domain.model.Office


package refactoring.catalog.replace.loop.domain.model;


import com.google.common.collect.ImmutableList;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.concurrent.ThreadSafe;
import java.util.Arrays;
import java.util.List;


@Value
@ThreadSafe
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
class Office {

    String city;

    String country;

    String telephone;

    static Office newOffice(@NonNull final String[] fields) {
        if (fields.length != 3) {
            return null;
        }
        return Office.of(
                fields[0].trim(),
                fields[1].trim(),
                fields[2].trim());
    }

    static List<Office> parse(@NonNull final String input,
                              @NonNull final String targetCountry) {

        String[] lines = input.split("\n");
        String[] loopItems = ArrayUtils.subarray(
                lines, 1, lines.length);

        return Arrays.stream(loopItems)
                .filter     (Office::isDataLineNotBlank)
                .map        (Office::parseDataLineToFields)
                .filter     (fields -> targetCountry.equals(fields[1].trim()))
                .map        (Office::newOffice)
                .collect    (ImmutableList.toImmutableList());
    }

    static boolean isDataLineNotBlank(@NonNull final String line) {
        return !StringUtils.isBlank(line);
    }

    static String[] parseDataLineToFields(@NonNull final String line) {
        return line.split(",");
    }

}///:~