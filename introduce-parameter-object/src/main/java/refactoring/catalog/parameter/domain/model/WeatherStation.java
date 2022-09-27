package refactoring.catalog.parameter.domain.model;


import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class WeatherStation {

    private String name;

    private List<WeatherReading> readings = Lists.newArrayList();

    public List<WeatherReading> getReadings() {
        return List.copyOf(this.readings);
    }

    public void setReadings(@NonNull final List<WeatherReading> readings) {
        this.readings = List.copyOf(readings);
    }

}
