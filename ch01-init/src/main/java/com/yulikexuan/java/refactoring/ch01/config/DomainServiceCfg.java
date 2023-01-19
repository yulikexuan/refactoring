package com.yulikexuan.java.refactoring.ch01.config;


import com.yulikexuan.java.refactoring.ch01.domain.service.StatementService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DomainServiceCfg {

    @Bean
    StatementService statementService() {
        return StatementService.of();
    }

}
