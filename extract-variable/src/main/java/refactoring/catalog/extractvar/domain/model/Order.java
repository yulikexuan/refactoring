package refactoring.catalog.extractvar.domain.model;


import lombok.RequiredArgsConstructor;
import lombok.Value;


@Value
@RequiredArgsConstructor(staticName = "of")
public class Order {

    long quantity;
    long itemPrice;
}