package com.yulikexuan.java.refactoring.catalog.extract.function.domain.service;


import com.yulikexuan.java.refactoring.catalog.extract.function.config.JsonCfg;
import com.yulikexuan.java.refactoring.catalog.extract.function.config.ResourceCfg;
import com.yulikexuan.java.refactoring.catalog.extract.function.domain.model.Invoice;
import com.yulikexuan.java.refactoring.catalog.extract.function.domain.model.InvoiceDto;
import com.yulikexuan.java.refactoring.catalog.extract.function.domain.model.OrderDto;
import com.yulikexuan.java.refactoring.json.JsonObjectConverter;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mutabilitydetector.unittesting.AllowedReason;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mutabilitydetector.unittesting.MutabilityAssert.assertInstancesOf;
import static org.mutabilitydetector.unittesting.MutabilityMatchers.areImmutable;


@ExtendWith(SpringExtension.class)
@DisplayName("Test StatementService - ")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@ContextConfiguration(classes = { JsonCfg.class, ResourceCfg.class})
class InvoiceStatementServiceTest {

    private Invoice invoice;

    private InvoiceStatementService invoiceStatementService;

    @Autowired
    private String invoiceJsonString;

    @Autowired
    private String expectedInvoiceStatement;

    @Autowired
    private JsonObjectConverter<Invoice> invoiceJsonObjectConverter;

    @BeforeEach
    void setUp() {
        this.invoice = invoiceJsonObjectConverter.toObject(invoiceJsonString).get();
        this.invoiceStatementService = new InvoiceStatementServiceImpl();
    }

    @Test
    void dto_Objects_Should_Be_Immutable() {
        assertInstancesOf(OrderDto.class, areImmutable());
        assertInstancesOf(InvoiceDto.class, areImmutable(),
                AllowedReason.provided(OrderDto.class).isAlsoImmutable());
    }

    @Test
    void able_To_Print_Statement_Of_An_Invoice() {
        String stmt = this.invoiceStatementService.printOwing(
                this.invoiceStatementService.convertInvoiceToInvoiceDto(invoice));
        assertThat(stmt).isEqualTo(this.expectedInvoiceStatement);
    }

}