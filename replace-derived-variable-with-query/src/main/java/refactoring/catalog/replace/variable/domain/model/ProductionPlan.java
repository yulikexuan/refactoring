//: refactoring.catalog.replace.variable.domain.model.ProductionPlan


package refactoring.catalog.replace.variable.domain.model;


import com.google.common.collect.ImmutableList;

import javax.annotation.concurrent.ThreadSafe;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;


/*
 * Ugliness is in the eye of beholder
 *
 * I see ugliness in duplication—not the common duplication of code but
 * duplication of data
 */
@ThreadSafe
class ProductionPlan {

    private final long initialProduction;

    private final Deque<Adjustment> adjustments = new ConcurrentLinkedDeque<>();

    ProductionPlan() {
        this.initialProduction = 0;
    }

    ProductionPlan(long initialProduction) {
        this.initialProduction = initialProduction;
    }

    /*
     * Not just storing that adjustment but also using it to modify an accumulator
     */
    public void applyAdjustment(Adjustment adjustment) {
        this.adjustments.push(adjustment);
    }

    public long production() {
        return this.calculatedProduction();
    }

    public List<Adjustment> adjustments() {
        return ImmutableList.copyOf(this.adjustments);
    }

    long calculatedProduction() {
        return this.initialProduction + this.adjustments.stream()
                .mapToLong(Adjustment::amount).sum();
    }

}///:~