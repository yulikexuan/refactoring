//: refactoring.catalog.api.domain.service.MiscreantSearchService


package refactoring.catalog.api.domain.service;


import com.google.common.collect.ImmutableList;
import lombok.NonNull;

import java.util.List;
import java.util.Optional;


class MiscreantSearchService {

    @NonNull
    private List<String> currentMiscreants;

    @NonNull
    private AlertService alertService;

    private MiscreantSearchService(List<String> currentMiscreants,
                                   AlertService alertService) {

        this.alertService = alertService;
        this.currentMiscreants = ImmutableList.copyOf(currentMiscreants);
    }

    static MiscreantSearchService of(@NonNull final List<String> currentMiscreants,
                                     @NonNull final AlertService alertService) {

        return new MiscreantSearchService(currentMiscreants, alertService);
    }

    public void alertForFoundMiscreant(@NonNull final List<String> names) {
        this.findMiscreantByName(names)
                .ifPresent(m -> this.alertService.sendAlert(m));
    }

    public Optional<String> findMiscreantByName(@NonNull final List<String> names) {

        boolean found = false;

        for (String name : names) {
            if (this.currentMiscreants.contains(name)) {
                return Optional.ofNullable(name);
            }
        }

        return Optional.empty();
    }

}///:~