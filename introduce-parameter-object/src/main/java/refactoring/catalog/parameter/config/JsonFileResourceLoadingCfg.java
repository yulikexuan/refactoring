package refactoring.catalog.parameter.config;


import com.yulikexuan.java.refactoring.io.ResourceReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class JsonFileResourceLoadingCfg {

    @Bean
    String weatherStationJsonString() {
        return ResourceReader.readFileToString("WeatherStation.json");
    }

}
