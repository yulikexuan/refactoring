package refactoring.catalog.encapsulate.record.domain.model;


import com.yulikexuan.java.refactoring.json.JsonObjectConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import refactoring.catalog.encapsulate.record.config.JsonFileResourceLoadingCfg;
import refactoring.catalog.encapsulate.record.config.JsonObjectConvertersCfg;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        JsonObjectConvertersCfg.class,
        JsonFileResourceLoadingCfg.class })
@DisplayName("Test CustomerDataRepository class - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class CustomerDataRepositoryTest {

    @Autowired
    private String customerJsonDataRepository;

    @Autowired
    private JsonObjectConverter<CustomerDataRepository> objectConverter;

    private CustomerDataRepository repository;

    @BeforeEach
    void setUp() {
        this.repository = this.objectConverter
                .toObject(this.customerJsonDataRepository)
                .orElseThrow();
    }

    @Test
    void class_CustomerData_Should_Be_Immutable() {

        // Given

        // When
        CustomerData cd1920 = this.repository.getCustomerDataByCustomerId("1920")
                .orElseThrow();

        Map<String, Map<String, Integer>> usages1920 = cd1920.usages();

        // Then
        assertThat(this.repository.allData().keySet())
                .containsExactlyInAnyOrder("38673", "1920");

        assertThat(cd1920.name()).isEqualTo("martin");
        assertThat(cd1920.id()).isEqualTo("1920");
        assertThat(usages1920.keySet())
                .containsExactlyInAnyOrder("2022", "2021");
    }

}///:~