package refactoring.catalog.encapsulate.record.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Accessors;

import java.util.Map;
import java.util.Optional;



@Data
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class CustomerDataRepository {

    private Map<String, CustomerData> allData;

    public Optional<CustomerData> getCustomerDataByCustomerId(
            @NonNull final String id) {

        return Optional.ofNullable(this.allData.get(id));
    }

    public int usage(@NonNull final String customerId,
                     @NonNull final String year,
                     @NonNull final String month) {

        return  this.allData.get(customerId).usages().get(year).amtByMonth(month);
    }

    public void usage(
            @NonNull final String customerId,
            @NonNull final String year,
            @NonNull final String month,
            final int amount) {

        this.allData.get(customerId).usages().get(year).amtByMonth(month, amount);
    }

}