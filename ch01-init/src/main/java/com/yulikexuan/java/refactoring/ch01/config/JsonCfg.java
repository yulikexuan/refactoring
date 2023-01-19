package com.yulikexuan.java.refactoring.ch01.config;


import com.yulikexuan.java.refactoring.ch01.domain.model.Invoice;
import com.yulikexuan.java.refactoring.ch01.domain.model.Performance;
import com.yulikexuan.java.refactoring.ch01.domain.model.Play;
import com.yulikexuan.java.refactoring.ch01.domain.model.PlayRepository;
import com.yulikexuan.java.refactoring.json.JsonObjectConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class JsonCfg {

    @Bean
    JsonObjectConverter<PlayRepository> playRepositoryJsonConverter() {
        return JsonObjectConverter.of(PlayRepository.class);
    }

    @Bean
    JsonObjectConverter<Play> playJsonObjectConverter() {
        return JsonObjectConverter.of(Play.class);
    }

    @Bean
    JsonObjectConverter<Performance> perfJsonConverter() {
        return JsonObjectConverter.of(Performance.class);
    }

    @Bean
    JsonObjectConverter<Invoice> invoiceJsonConverter() {
        return JsonObjectConverter.of(Invoice.class);
    }

}