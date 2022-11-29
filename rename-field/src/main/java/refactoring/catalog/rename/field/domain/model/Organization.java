//: refactoring.catalog.rename.field.domain.model.Organization


package refactoring.catalog.rename.field.domain.model;


import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.Accessors;

import javax.annotation.concurrent.ThreadSafe;


@Value
@ThreadSafe
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
public class Organization {

    @NonNull
    String title;

    @NonNull
    String country;

}///:~