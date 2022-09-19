package refactoring.catalog.inlinefunc.domain.model;


import lombok.RequiredArgsConstructor;
import lombok.Value;


@Value
@RequiredArgsConstructor(staticName = "of")
public class Driver {
    int numberOfLateDeliveries;
}
