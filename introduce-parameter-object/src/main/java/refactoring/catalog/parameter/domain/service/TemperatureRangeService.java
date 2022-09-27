package refactoring.catalog.parameter.domain.service;


import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import refactoring.catalog.parameter.domain.model.WeatherReading;
import refactoring.catalog.parameter.domain.model.WeatherStation;

import java.util.List;


public sealed interface TemperatureRangeService
        permits TemperatureRangeServiceImpl {

    List<WeatherReading> readingsOutsideRange(WeatherStation station, int min, int max);
}


final class TemperatureRangeServiceImpl implements TemperatureRangeService {

    @Override
    public List<WeatherReading> readingsOutsideRange(
            @NonNull final WeatherStation station, final int min, final int max) {

        return station.getReadings().stream()
                .filter(r -> r.getTemp() < min || r.getTemp() > max)
                .collect(ImmutableList.toImmutableList());
    }

}