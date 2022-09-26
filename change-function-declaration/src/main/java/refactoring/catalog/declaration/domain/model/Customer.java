package refactoring.catalog.declaration.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class Customer {

    private String name;
    private Address address;
}
