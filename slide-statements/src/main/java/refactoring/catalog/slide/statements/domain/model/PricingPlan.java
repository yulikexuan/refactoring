//: refactoring.catalog.slide.statements.domain.model.PricingPlan


package refactoring.catalog.slide.statements.domain.model;


import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;

import javax.annotation.concurrent.ThreadSafe;


@Value
@ThreadSafe
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
public class PricingPlan {

    long baseCharge;

    long chargePerUnit;

    int discountThreshold;

    int discountFactor;

}///:~