package refactoring.catalog.splitphase.app;


import com.yulikexuan.java.refactoring.json.JsonObjectConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import refactoring.catalog.splitphase.config.JsonFileResourceLoadingCfg;
import refactoring.catalog.splitphase.config.JsonObjectConvertersCfg;
import refactoring.catalog.splitphase.domain.model.Payment;
import refactoring.catalog.splitphase.domain.model.PaymentCountingCommand;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;


@ExtendWith(SpringExtension.class)
@DisplayName("Test SplittingCommandLineApp class- ")
@DisplayNameGeneration(ReplaceUnderscores.class)
@ContextConfiguration(classes = {
        JsonObjectConvertersCfg.class,
        JsonFileResourceLoadingCfg.class })
class SplittingCommandLineAppTest {

    @Autowired
    private String paymentsJsonString;

    @Autowired
    private JsonObjectConverter<Payment[]> paymentJsonObjectConverter;

    private SplittingCommandLineApp app;

    @BeforeEach
    void setUp() {
        app = SplittingCommandLineApp.of(this.paymentJsonObjectConverter);
    }

    @ParameterizedTest
    @CsvSource({"false, 6", "true, 4"})
    void able_To_Count_Payments(boolean ready, long expectAmt) {

        // Given
        PaymentCountingCommand command =
                PaymentCountingCommand.of(paymentsJsonString, ready);

        // When
        long actualAmt = app.countPayments(command);

        // Then
        assertThat(actualAmt).isEqualTo(expectAmt);
    }

    @Test
    void test_Class_Loaders() {

    }

}///:~