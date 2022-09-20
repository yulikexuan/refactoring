package refactoring.catalog.extractvar.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class Order {

    long quantity;
    long itemPrice;

}