package com.yulikexuan.java.refactoring.catalog.extract.function.config;


import com.yulikexuan.java.refactoring.catalog.extract.function.domain.model.Invoice;
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