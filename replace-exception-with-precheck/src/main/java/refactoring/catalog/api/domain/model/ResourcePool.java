//: refactoring.catalog.api.domain.model.ResourcePool


package refactoring.catalog.api.domain.model;


import lombok.RequiredArgsConstructor;

import java.util.Deque;
import java.util.List;
import java.util.NoSuchElementException;


@RequiredArgsConstructor(staticName = "of")
class ResourcePool {

    private final Deque<Resource> available;

    private final List<Resource> allocated;

    Resource resource() {

        Resource result = this.available.isEmpty() ?
                Resource.of() : available.pop();

        this.allocated.add(result);

        /*
         * Running Out Of Resources for the Pool is NOT an Unexpected Condition
         * So Exception Handling is the Wrong Mechanism to use
         *
         * So Testing the Allocated Collection Beforehand is just As Easy
         * and More Clearly Communicates that this is Expected Behavior
         */
        //        try {
        //            result = available.pop();
        //            allocated.add(result);
        //        } catch (NoSuchElementException e) {
        //            result = Resource.of();
        //            allocated.add(result);
        //        }

        return result;
    }

}///:~