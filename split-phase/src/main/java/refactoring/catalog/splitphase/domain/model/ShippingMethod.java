//: refactoring.catalog.splitphase.domain.model.ShippingMethod


package refactoring.catalog.splitphase.domain.model;


import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;


@Value
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
public class ShippingMethod {

    int discountThreshold;

    int discountedFee;

    int feePerCase;

}///:~