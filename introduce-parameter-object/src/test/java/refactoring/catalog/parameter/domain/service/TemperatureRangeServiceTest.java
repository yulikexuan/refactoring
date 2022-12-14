package refactoring.catalog.parameter.domain.service;


import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
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
import refactoring.catalog.parameter.config.JsonFileResourceLoadingCfg;
import refactoring.catalog.parameter.config.JsonObjectConvertersCfg;
import refactoring.catalog.parameter.domain.model.NumberRange;
import refactoring.catalog.parameter.domain.model.WeatherReadingDto;
import refactoring.catalog.parameter.domain.model.WeatherStation;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import static org.mutabilitydetector.unittesting.MutabilityAssert.assertImmutable;


@ExtendWith(SpringExtension.class)
@DisplayName("Test TemperatureRangeService class - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
@ContextConfiguration(classes = {
        JsonObjectConvertersCfg.class,
        JsonFileResourceLoadingCfg.class })
class TemperatureRangeServiceTest {

    @Autowired
    private String weatherStationJsonString;

    @Autowired
    private JsonObjectConverter<WeatherStation> weatherStationJsonObjectConverter;

    private WeatherStation weatherStation;

    private TemperatureRangeService tempRangeService;

    @BeforeEach
    void setUp() {
        this.weatherStation = this.weatherStationJsonObjectConverter.toObject(
                this.weatherStationJsonString).get();
        this.tempRangeService = new TemperatureRangeServiceImpl();
    }

    @ParameterizedTest
    @CsvSource({"14, 16", "13, 15", "10, 16", "15, 20"})
    void able_To_Filter_Readings_Out_Of_A_Range(int min, int max) {

        // Given

        // When
        final List<WeatherReadingDto> outsideReadings =
                this.tempRangeService.readingsOutsideRange(
                        this.weatherStation, NumberRange.of(min, max));

        final List<WeatherReadingDto> insideReadings =
                this.weatherStation.weatherReadings()
                        .stream()
                        .filter(r -> !outsideReadings.contains(r))
                        .collect(ImmutableList.toImmutableList());

        // Then
        long wrongOutsideReadings = outsideReadings.stream()
                .filter(r -> r.getTemp() >= min && r.getTemp() <= max)
                .count();
        assertThat(wrongOutsideReadings).isZero();

        long wrongInsideReadings = insideReadings.stream()
                .filter(r -> r.getTemp() < min || r.getTemp() > max)
                .count();
        assertThat(wrongInsideReadings).isZero();

        List<WeatherReadingDto> recombinedReadings = Lists.newArrayList();
        recombinedReadings.addAll(outsideReadings);
        recombinedReadings.addAll(insideReadings);
        assertThat(recombinedReadings).containsExactlyInAnyOrderElementsOf(
                weatherStation.weatherReadings());
    }

    @Test
    void the_DTO_Of_WeatherReading_Should_Be_Immutable() {

        // Given

        // When
        assertImmutable(WeatherReadingDto.class);
    }

}