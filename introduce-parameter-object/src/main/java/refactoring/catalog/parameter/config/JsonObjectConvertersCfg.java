package refactoring.catalog.parameter.config;


import com.yulikexuan.java.refactoring.json.JsonObjectConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import refactoring.catalog.parameter.domain.model.WeatherStation;


@Configuration
public class JsonObjectConvertersCfg {

    @Bean
    JsonObjectConverter<WeatherStation> weatherStationJsonObjectConverter() {
        return JsonObjectConverter.of(WeatherStation.class);
    }

}