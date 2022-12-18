package refactoring.catalog.api.domain.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;
import static org.mutabilitydetector.unittesting.MutabilityAssert.assertImmutable;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test class AirConditioningSystem - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class AirConditioningSystemTest {

    @Mock
    private AirConditioningController controller;

    @Mock
    private Thermostat thermostat;

    private HeatingPlan heatingPlan;

    private AirConditioningSystem airConditioningSystem;

    @BeforeEach
    void setUp() {
    }

    @Test
    void class_Heating_Plan_Should_Be_Immutable() {
        assertImmutable(HeatingPlan.class);
    }

    @ParameterizedTest
    @CsvSource({ "23, 17, 20, 18, 1, 0, 0",
            "23, 17, 18, 20, 0, 1, 0",
            "23, 17, 20, 20, 0, 0, 1",
            "23, 17, 25, 18, 1, 0, 0",
            "23, 17, 14, 19, 0, 1, 0",
    })
    void able_To_Adjust_Temperature(int maxTemp,
                                    int minTemp,
                                    int selectedTemp,
                                    int currentTemp,
                                    int heatingTimes,
                                    int coolingTimes,
                                    int offTimes) throws Exception {

        // Given
        this.heatingPlan = HeatingPlan.of(maxTemp, minTemp);
        this.airConditioningSystem = AirConditioningSystem.of(
                this.thermostat, this.heatingPlan, this.controller);

        given(thermostat.selectedTemperature()).willReturn(selectedTemp);
        given(thermostat.currentTemperature()).willReturn(currentTemp);

        // When
        this.airConditioningSystem.run();

        // Then
        then(this.controller).should(times(heatingTimes)).setToHeat();
        then(this.controller).should(times(coolingTimes)).setToCool();
        then(this.controller).should(times(offTimes)).setOff();
    }

}///:~