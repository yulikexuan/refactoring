//: refactoring.catalog.encapsulate.record.domain.model.CustomerData


package refactoring.catalog.encapsulate.record.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Map;


@Data
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class CustomerData {

    String name;

    String id;

    Map<String, Map<String, Integer>> usages;

}///:~