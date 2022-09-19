package refactoring.catalog.inlinefunc.domain.service;


import refactoring.catalog.inlinefunc.domain.model.Driver;


public class DriverRatingService {

    public int ratingDriver(Driver driver) {
        return moreThanFiveLateDeliveries(driver) ? 2 : 1;
    }

    private boolean moreThanFiveLateDeliveries(Driver driver) {
        return driver.getNumberOfLateDeliveries() > 5;
    }

}