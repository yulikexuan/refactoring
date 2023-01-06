//: refactoring.catalog.inheritance.domain.model.init.Scroll


package refactoring.catalog.inheritance.domain.model.init;


import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.Accessors;
import refactoring.catalog.inheritance.domain.model.CatalogItem;
import refactoring.catalog.inheritance.domain.model.IScroll;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;


@Getter
@Accessors(fluent = true)
class Scroll extends CatalogItem implements IScroll {

    private LocalDate dateLastCleaned;

    private Scroll(final int id,
                   @NonNull final String title,
                   @NonNull final List<String> tags,
                   @NonNull final LocalDate dateLastCleaned) {

        super(id, title, tags);
        this.dateLastCleaned = dateLastCleaned;
    }

    @Override
    public boolean needsCleaning(@NonNull final LocalDate targetDate) {
        final int threshold =  this.hasTag("revered") ? 700 : 1500;
        return this.daysSinceLastCleaning(targetDate) > threshold ;
    }

    @Override
    public long daysSinceLastCleaning(@NonNull final LocalDate targetDate) {
        return this.dateLastCleaned.until(targetDate, ChronoUnit.DAYS);
    }

}///:~