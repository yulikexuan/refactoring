//: refactoring.catalog.splitphase.config.JsonFileResourceLoadingCfg


package refactoring.catalog.splitphase.config;


import com.yulikexuan.java.refactoring.io.ResourceReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class JsonFileResourceLoadingCfg {

    @Bean
    public String paymentsJsonString() {
        return ResourceReader.readFileToString("Payments.json");
    }

}///:~