//: refactoring.catalog.splitphase.config.JsonObjectConvertersCfg


package refactoring.catalog.splitphase.config;


import com.yulikexuan.java.refactoring.json.JsonObjectConverter;
import org.springframework.context.annotation.Bean;
import refactoring.catalog.splitphase.domain.model.Payment;


public class JsonObjectConvertersCfg {

    @Bean
    JsonObjectConverter<Payment[]> paymentJsonObjectConverter() {
        return JsonObjectConverter.of(Payment[].class);
    }

}///:~