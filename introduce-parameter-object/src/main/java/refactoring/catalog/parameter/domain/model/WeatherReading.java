package refactoring.catalog.parameter.domain.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public final class WeatherReading {

    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm";

    private int temp;

    @JsonFormat(pattern = DATE_TIME_FORMAT, shape = JsonFormat.Shape.STRING)
    private LocalDateTime time;

}