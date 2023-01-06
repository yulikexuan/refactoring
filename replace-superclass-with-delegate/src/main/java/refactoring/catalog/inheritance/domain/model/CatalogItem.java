//: refactoring.catalog.inheritance.domain.model.CatalogItem


package refactoring.catalog.inheritance.domain.model;


import com.google.common.collect.ImmutableList;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.Accessors;

import java.util.List;


@Getter
@Accessors(fluent = true)
public class CatalogItem implements ICatalog {

    final int id;

    final String title;

    final List<String> tags;

    public CatalogItem(final int id,
                @NonNull final String title,
                @NonNull final List<String> tags) {

        this.id = id;
        this.title = title;
        this.tags = ImmutableList.copyOf(tags);
    }

    @Override
    public List<String> tags() {
        return ImmutableList.copyOf(this.tags);
    }

    @Override
    public boolean hasTag(@NonNull final String tag) {
        return this.tags.contains(tag);
    }

}///:~