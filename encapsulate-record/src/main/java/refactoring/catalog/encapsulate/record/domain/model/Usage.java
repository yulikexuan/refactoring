//: refactoring.catalog.encapsulate.record.domain.model.Usage


package refactoring.catalog.encapsulate.record.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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