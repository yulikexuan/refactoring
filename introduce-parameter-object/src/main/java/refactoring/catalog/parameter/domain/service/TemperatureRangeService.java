package refactoring.catalog.parameter.domain.service;


import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import refactoring.catalog.parameter.domain.model.NumberRange;
import refactoring.catalog.parameter.domain.model.WeatherReadingDto;
import refactoring.catalog.parameter.domain.model.WeatherStation;

import java.util.List;


public sealed interface TemperatureRangeService
        permits TemperatureRangeServiceImpl {

    List<WeatherReadingDto> readingsOutsideRange(
            WeatherStation station, NumberRange numberRange);
}


final class TemperatureRangeServiceImpl implements TemperatureRangeService {

    @Override
    public List<WeatherReadingDto> readingsOutsideRange(
            @NonNull final WeatherStation station,
            @NonNull final NumberRange numberRange) {

        return station.weatherReadings().stream()
                .filter(r -> this.isOutside(r.getTemp(), numberRange))
                .collect(ImmutableList.toImmutableList());
    }

    private boolean isOutside(@NonNull final int temp,
                              @NonNull final NumberRange numberRange) {

        return temp < numberRange.min() || temp > numberRange.max();
    }

}