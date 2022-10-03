package refactoring.catalog.funcombine.domain.service;


public interface TaxRateService {

    int baseRate(int month, int year);

    int taxThreshold(int year);

}