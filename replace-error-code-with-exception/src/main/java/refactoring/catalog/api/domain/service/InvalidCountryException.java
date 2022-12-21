//: refactoring.catalog.api.domain.service.InvalidCountryException


package refactoring.catalog.api.domain.service;


public class InvalidCountryException extends RuntimeException {

    private int errorCode;

    private InvalidCountryException(int errorCode) {
        super();
        this.errorCode = errorCode;
    }

    public static InvalidCountryException of(final int errorCode) {
        return new InvalidCountryException(errorCode);
    }

}///:~