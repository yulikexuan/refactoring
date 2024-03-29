package com.yulikexuan.java.refactoring.ch01.domain.service;


import com.yulikexuan.java.refactoring.ch01.config.DomainServiceCfg;
import com.yulikexuan.java.refactoring.ch01.config.JsonCfg;
import com.yulikexuan.java.refactoring.ch01.config.LoadingResourceCfg;
import com.yulikexuan.java.refactoring.ch01.domain.model.*;
import com.yulikexuan.java.refactoring.json.JsonObjectConverter;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;


// @ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        JsonCfg.class,
        LoadingResourceCfg.class,
        DomainServiceCfg.class })
@DisplayName("Test StatementService - ")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StatementServiceTest {

    @Autowired
    private String invoiceJsonString;

    @Autowired
    private String playsJsonString;

    @Autowired
    private String expectedStmt;

    @Autowired
    private StatementService statementService;

    @Autowired
    private JsonObjectConverter<PlayRepository> playRepositoryJsonConverter;

    @Autowired
    private JsonObjectConverter<Play> playJsonObjectConverter;

    @Autowired
    private JsonObjectConverter<Performance> perfJsonConverter;

    @Autowired
    private JsonObjectConverter<Invoice> invoiceJsonConverter;

    private ThreadLocalRandom random;

    @BeforeEach
    void setUp() {
        this.random = ThreadLocalRandom.current();
    }

    @Nested
    @DisplayName("Test StatementServiceImpl - ")
    class StatementServiceImplTest {

        private PlayRepository playRepository;

        private Invoice invoice;

        @BeforeEach
        void setUp() {
            this.invoice = invoiceJsonConverter
                    .toObject(invoiceJsonString)
                    .get();

            playRepository = playRepositoryJsonConverter
                    .toObject(playsJsonString)
                    .get();
        }

        @Test
        void able_To_Print_Invoice_Statement() {

            // Given

            // When
            String stmt = statementService.getStatement(
                    this.invoice, this.playRepository);

            // Then
            assertThat(stmt).isEqualTo(expectedStmt);
        }

    }// End of class StatementServiceImplTest

    @Nested
    @DisplayName("Test Domain Model - Play - ")
    class PlayModelTest {

        static final String PLAY_JSON_TEMPLATE =
                "{\"name\":\"%s\",\"playType\":\"%s\"}";

        private String playName;

        @BeforeAll
        static void beforeAll() {
        }

        @BeforeEach
        void setUp() {
            this.playName = RandomStringUtils.randomAlphabetic(7);
        }

        @ParameterizedTest
        @EnumSource(PlayType.class)
        void from_Play_Object_To_Json(PlayType playType) {

            // Given
            Play play = Play.of(this.playName, playType);
            String expectedJson = String.format(PLAY_JSON_TEMPLATE,
                    this.playName, playType.name());

            // When
            Optional<String> playJson = playJsonObjectConverter.toJson(play);

            // Then
            playJson.ifPresentOrElse(p -> assertThat(p).isEqualTo(expectedJson),
                    () -> fail("Converting failed!"));
        }

        @ParameterizedTest
        @EnumSource(PlayType.class)
        void from_Json_To_Play(PlayType playType) {

            // Given
            String json = String.format(PLAY_JSON_TEMPLATE, playName, playType.name());

            // When
            Optional<Play> playOpt = playJsonObjectConverter.toObject(json);

            // Then
            assertThat(playOpt).contains(Play.of(playName, playType));
        }

    } // End of class PlayModelTest

    @Nested
    @DisplayName("Test Domain Model - Performance - ")
    class PerformanceModelTest {

        static final String PERF_JSON_TEMPLATE =
                "{\"playId\":\"%s\",\"audience\":%d}";

        private String playId;
        private int audience;

        @BeforeAll
        static void beforeAll() {
        }

        @BeforeEach
        void setUp() {
            this.playId = RandomStringUtils.randomAlphabetic(7);
            this.audience = random.nextInt(100, 1000);
        }

        @Test
        void from_Performance_To_Json() {

            // Given
            Performance perf = Performance.of(this.playId, this.audience);
            String expectedJson = String.format(PERF_JSON_TEMPLATE,
                    this.playId, this.audience);

            // When
            Optional<String> jsonOpt = perfJsonConverter.toJson(perf);

            // Then
            jsonOpt.ifPresentOrElse(p -> assertThat(p).isEqualTo(expectedJson),
                    () -> fail("Converting failed!"));
        }

        @Test
        void from_Json_To_Performance() {

            // Given
            String json = String.format(
                    PERF_JSON_TEMPLATE, this.playId, this.audience);

            // When
            Optional<Performance> performanceOpt = perfJsonConverter.toObject(json);

            // Then
            assertThat(performanceOpt).contains(Performance.of(
                    this.playId, this.audience));
        }

    } // End of class PerformanceModelTest

    @Nested
    @DisplayName("Test Domain Model - Invoice - ")
    class InvoiceModelTest {

        static final String EXPECTED_CUSTOMER_NAME = "BigCo";

        static final List<Performance> EXPECTED_PERF_LIST = List.of(
                Performance.of("hamlet", 55),
                Performance.of("as-like", 35),
                Performance.of("othello", 40)
        );

        static final Invoice EXPECTED_INVOICE = Invoice.of(
                EXPECTED_CUSTOMER_NAME, EXPECTED_PERF_LIST);

        @BeforeAll
        static void beforeAll() {
        }

        @Test
        void json_To_Invoice() {

            // Given
            Optional<Invoice> invoiceOpt = invoiceJsonConverter.toObject(
                    invoiceJsonString);

            // When
            Invoice invoice = invoiceOpt.orElseThrow();

            // Then
            assertThat(invoice).isEqualTo(EXPECTED_INVOICE);
        }

        @Test
        void invoice_Object_To_Json() {

            // Given
            String expectedJson = "{\"customer\":\"BigCo\",\"performances\":[{\"playId\":\"hamlet\",\"audience\":55},{\"playId\":\"as-like\",\"audience\":35},{\"playId\":\"othello\",\"audience\":40}]}";

            // When
            String invoiceJson = invoiceJsonConverter.toJson(EXPECTED_INVOICE).get();

            // Then
            assertThat(invoiceJson).isEqualTo(expectedJson);
        }

    } // End of class InvoiceModelTest

} // End of class StatementServiceTest