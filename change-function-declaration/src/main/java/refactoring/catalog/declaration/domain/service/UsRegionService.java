package refactoring.catalog.declaration.domain.service;


import lombok.NonNull;

import java.util.List;


public sealed interface UsRegionService permits UsRegionServiceImpl {

    List<String> NEW_ENGLAND_REGION_STATES = List.of("MA", "CT", "ME", "VT", "NH", "RI");

    boolean inNewEngland(String stateCode);

}

final class UsRegionServiceImpl implements UsRegionService {

    @Override
    public boolean inNewEngland(@NonNull final String stateCode) {
        return NEW_ENGLAND_REGION_STATES.contains(stateCode);
    }

}