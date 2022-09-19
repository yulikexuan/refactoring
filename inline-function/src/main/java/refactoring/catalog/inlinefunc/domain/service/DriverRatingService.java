package refactoring.catalog.inlinefunc.domain.service;


import lombok.NonNull;
import refactoring.catalog.inlinefunc.domain.model.Driver;


public class DriverRatingService {

    public int ratingDriver(@NonNull final Driver driver) {
        return driver.getNumberOfLateDeliveries() > 5 ? 2 : 1;
    }

//    private boolean moreThanFiveLateDeliveries(@NonNull final Driver driver) {
//        return driver.getNumberOfLateDeliveries() > 5;
//    }

}