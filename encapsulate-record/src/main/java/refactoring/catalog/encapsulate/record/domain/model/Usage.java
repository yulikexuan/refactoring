//: refactoring.catalog.encapsulate.record.domain.model.Usage


package refactoring.catalog.encapsulate.record.domain.model;


import com.google.common.collect.ImmutableMap;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.Accessors;

import java.util.Map;


@Value
@Accessors(fluent = true)
public class Usage {

    Map<String, Integer> usage;

    private Usage(Map<String, Integer> usage) {
        this.usage = usage;
    }

    public static Usage of(@NonNull final Map<String, Integer> usage) {
        return new Usage(ImmutableMap.copyOf(usage));
    }

    public Map<String, Integer> getUsage() {
        return ImmutableMap.copyOf(this.usage);
    }

}///:~