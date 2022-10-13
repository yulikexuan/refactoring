//: refactoring.catalog.encapsulate.record.config.JsonFileResourceLoadingCfg


package refactoring.catalog.encapsulate.record.config;


import com.yulikexuan.java.refactoring.io.ResourceReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class JsonFileResourceLoadingCfg {

    @Bean
    public String customerJsonDataRepository() {
        return ResourceReader.readFileToString("CustomerDataRepository.json");
    }

}///:~