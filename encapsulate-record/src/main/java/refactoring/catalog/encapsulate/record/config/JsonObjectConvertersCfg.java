//: refactoring.catalog.encapsulate.record.config.JsonObjectConvertersCfg


package refactoring.catalog.encapsulate.record.config;


import com.yulikexuan.java.refactoring.json.JsonObjectConverter;
import org.springframework.context.annotation.Bean;
import refactoring.catalog.encapsulate.record.domain.model.CustomerDataRepository;


public class JsonObjectConvertersCfg {

    @Bean
    public JsonObjectConverter<CustomerDataRepository> customerDataJsonObjectConverter() {
        return JsonObjectConverter.of(CustomerDataRepository.class);
    }

}///:~