package com.yulikexuan.java.refactoring.catalog.extract.function.config;


import com.yulikexuan.java.refactoring.io.ResourceReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ResourceCfg {

    @Bean
    public String invoiceJsonString() {
        return ResourceReader.readFileToString("Invoice.json");
    }

    @Bean
    public String expectedInvoiceStatement() {
        return ResourceReader.readFileToString("ExpectedInvoiceStatement.txt");
    }

}