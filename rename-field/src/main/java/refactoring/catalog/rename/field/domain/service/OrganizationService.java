//: refactoring.catalog.rename.field.domain.service.OrganizationService


package refactoring.catalog.rename.field.domain.service;


import com.google.common.collect.ImmutableSet;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import refactoring.catalog.rename.field.domain.model.Organization;

import java.util.List;
import java.util.Set;


public interface OrganizationService {

    Set<Organization> organizationsWithSuffix(
            List<Organization> organizations, String suffix);

    static OrganizationService of() {
        return OrganizationServiceImpl.of();
    }
}

@AllArgsConstructor(staticName = "of")
final class OrganizationServiceImpl implements OrganizationService {

    @Override
    public Set<Organization> organizationsWithSuffix(
            @NonNull final List<Organization> organizations,
            @NonNull final String suffix) {

        return organizations.stream()
                .filter(org -> org.title().endsWith(suffix))
                .collect(ImmutableSet.toImmutableSet());
    }

}///:~