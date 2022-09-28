package com.yulikexuan.java.refactoring.ch01.config;


import com.yulikexuan.java.refactoring.io.ResourceReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class JsonFileResourceLoadingCfg {

    @Bean
    public String invoiceJsonString() {
        return ResourceReader.readFileToString("Invoice.json");
    }

    @Bean
    public String playsJsonString() {
        return ResourceReader.readFileToString("Plays.json");
    }

    @Bean
    public String expectedStmt() {
        return ResourceReader.readFileToString("ExpectedStmt.txt");
    }

    @Bean
    public String expectedHtmlStmt() {
        return ResourceReader.readFileToString("ExpectedHtmlStmt.txt");
    }

}