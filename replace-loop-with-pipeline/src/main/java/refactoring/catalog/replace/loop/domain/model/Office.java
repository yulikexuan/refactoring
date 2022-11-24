//: refactoring.catalog.replace.loop.domain.model.Office


package refactoring.catalog.replace.loop.domain.model;


import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.concurrent.ThreadSafe;
import java.util.List;


@Value
@ThreadSafe
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
class Office {

    String city;

    String country;

    String telephone;

    /*
     *   function acquireData(input) {
    const lines = input.split("\n");
    let firstLine = true;
    const result = [];
    for (const line of lines) {
      if (firstLine) {
        firstLine = false;
        continue;
      }
      if (line.trim() === "") continue;
      const record = line.split(",");
      if (record[1].trim() === "India") {
        result.push({city: record[0].trim(), phone: record[2].trim()});
      }
    }
    return result;
  }
     */
    static List<Office> parse(@NonNull final String input,
                              @NonNull final String targetCountry) {

        String[] lines = input.split("\n");

        boolean firstLine = true;

        List<Office> offices = Lists.newArrayList();

        for (String line : lines) {
            if (firstLine) {
                firstLine = false;
                continue;
            }
            if (StringUtils.isBlank(line)) {
                continue;
            }
            String[] fields = line.split(",");
            String country = fields[1].trim();
            if (targetCountry.equals(country)) {
                offices.add(Office.of(
                        fields[0].trim(),
                        fields[1].trim(),
                        fields[2].trim()));
            }
        }

        return offices;
    }

}///:~