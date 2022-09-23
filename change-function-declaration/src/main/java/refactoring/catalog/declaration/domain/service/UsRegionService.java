package refactoring.catalog.declaration.domain.service;


import refactoring.catalog.declaration.domain.model.Customer;

import java.util.List;


public sealed interface UsRegionService permits UsRegionServiceImpl {

    List<String> NEW_ENGLAND_REGION_STATES = List.of("MA", "CT", "ME", "VT", "NH", "RI");

    boolean inNewEngland(Customer customer);

}

final class UsRegionServiceImpl implements UsRegionService {

    @Override
    public boolean inNewEngland(Customer customer) {
        return NEW_ENGLAND_REGION_STATES.contains(
                customer.getAddress().getStateCode());
    }

}