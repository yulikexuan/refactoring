//: refactoring.catalog.encapsulate.record.domain.model.Usage


package refactoring.catalog.encapsulate.record.domain.model;


import com.google.common.collect.ImmutableMap;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Map;


@Data
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
public class Usage {

    private Map<String, Integer> usage;

    public int amtByMonth(String month) {
        return usage.get(month);
    }

    public void amtByMonth(String month, int amt) {
        usage.put(month, amt);
    }

}///:~