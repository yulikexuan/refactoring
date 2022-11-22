//: refactoring.catalog.move.statements.domain.model.Photo


package refactoring.catalog.move.statements.domain.model;


import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;

import java.time.LocalDate;


@Value
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
public class Photo {

    String title;
    LocalDate date;
    String location;

}///:~