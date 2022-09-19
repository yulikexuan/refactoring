package refactoring.extractfunc.config;


import refactoring.extractfunc.domain.model.Invoice;
import com.yulikexuan.java.refactoring.json.JsonObjectConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class JsonCfg {

    @Bean
    JsonObjectConverter<Invoice> invoiceJsonObjectConverter() {
        return JsonObjectConverter.of(Invoice.class);
    }

}