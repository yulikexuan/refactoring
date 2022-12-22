//: refactoring.catalog.api.domain.model.Resource


package refactoring.catalog.api.domain.model;


import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;

import javax.annotation.concurrent.ThreadSafe;


public interface Resource {

    static Resource of() {
        return ResourceImpl.of();
    }
}

@Value
@ThreadSafe
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
class ResourceImpl implements Resource {

}

///:~