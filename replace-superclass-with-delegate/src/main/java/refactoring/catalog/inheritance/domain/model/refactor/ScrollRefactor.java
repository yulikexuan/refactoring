//: refactoring.catalog.inheritance.domain.model.refactor.ScrollRefactor


package refactoring.catalog.inheritance.domain.model.refactor;


import com.google.common.collect.ImmutableList;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.Accessors;
import refactoring.catalog.inheritance.domain.model.ICatalog;
import refactoring.catalog.inheritance.domain.model.IScroll;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;


@Getter
@Accessors(fluent = true)
public class ScrollRefactor implements IScroll  {

    private final int id;

    private final ICatalog catalogItem;

    private final LocalDate dateLastCleaned;

    public ScrollRefactor(final int id,
                          @NonNull final ICatalog catalogItem,
                          @NonNull final LocalDate dateLastCleaned) {

        this.id = id;
        this.catalogItem = catalogItem;
        this.dateLastCleaned = dateLastCleaned;
    }

    @Override
    public int id() {
        return this.id;
    }

    @Override
    public String title() {
        return this.catalogItem.title();
    }

    @Override
    public List<String> tags() {
        return ImmutableList.copyOf(this.catalogItem.tags());
    }

    @Override
    public boolean hasTag(@NonNull final String tag) {
        return this.catalogItem.tags().contains(tag);
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