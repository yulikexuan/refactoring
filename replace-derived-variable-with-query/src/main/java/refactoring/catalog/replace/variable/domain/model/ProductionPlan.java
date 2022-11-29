//: refactoring.catalog.replace.variable.domain.model.ProductionPlan


package refactoring.catalog.replace.variable.domain.model;


import java.util.ArrayDeque;
import java.util.Deque;


/*
 * Ugliness is in the eye of beholder
 *
 * I see ugliness in duplication—not the common duplication of code but
 * duplication of data
 */
class ProductionPlan {

    long production;

    Deque<Adjustment> adjustments = new ArrayDeque<>();

    ProductionPlan() {
    }

    /*
     * Not just storing that adjustment but also using it to modify an accumulator
     */
    public long applyAdjustment(Adjustment adjustment) {

        this.adjustments.push(adjustment);
        this.production += adjustment.amount();

        return this.production;
    }

    public long production() {
        return this.production;
    }

}///:~