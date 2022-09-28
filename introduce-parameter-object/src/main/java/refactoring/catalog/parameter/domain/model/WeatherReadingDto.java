package refactoring.catalog.parameter.domain.model;


import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;

import java.time.LocalDateTime;


@Value
@AllArgsConstructor(staticName = "of")
public class WeatherReadingDto {

    int temp;

    LocalDateTime time;

    public static WeatherReadingDto of(
            @NonNull final WeatherReading weatherReading) {

        return WeatherReadingDto.of(
                weatherReading.getTemp(), weatherReading.getTime());
    }

}