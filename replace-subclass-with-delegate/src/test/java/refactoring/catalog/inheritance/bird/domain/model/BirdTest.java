package refactoring.catalog.inheritance.bird.domain.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import static org.mutabilitydetector.unittesting.MutabilityAssert.assertImmutable;
import static refactoring.catalog.inheritance.bird.domain.model.PlumageType.NORWEGIAN_BLUE_PARROT;
import static refactoring.catalog.inheritance.bird.domain.model.PlumageType.SCORCHED;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test Refactoring of Bird - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class BirdTest {

    private IBird bird;

    @BeforeEach
    void setUp() {
    }

    @Test
    void class_BirdDto_Should_Be_Immutable() {
        assertImmutable(BirdDto.class);
    }

    @Test
    void european_Swallow_Has_Air_Speed_Velocity_35() {

        // Given
        IBird bird = IBird.of(BirdDto.of(
                "es",
                PlumageType.EUROPEAN_SWALLOW,
                0,
                0,
                false));

        // When
        int actualAirSpeedVelocity = bird.airSpeedVelocity();

        // Then
        assertThat(actualAirSpeedVelocity).isEqualTo(35);
    }

    @ParameterizedTest
    @CsvSource({ "0, 40", "5, 30", "10, 20", "15, 10", "20, 0", "25, -10", "30, -20" })
    void african_Swallow_Air_Speed_Velocity_Depends_On_Num_Of_Coconuts(
            int numOfCoconuts, int expectedSpeed) {

        // Given
        IBird bird = IBird.of(BirdDto.of(
                "es",
                PlumageType.AFRICAN_SWALLOW,
                numOfCoconuts,
                0,
                false));

        // When
        int airSpeedVelocity = bird.airSpeedVelocity();

        // Then
        assertThat(airSpeedVelocity).isEqualTo(expectedSpeed);
    }

    @ParameterizedTest
    @CsvSource({
            "true, 10, 0",
            "false, 1, 10",
            "false, 4, 10",
            "false, 5, 10",
            "false, 9, 10",
            "false, 10, 11",
            "false, 19, 11",
            "false, 20, 12",
            "false, 30, 13",
            "false, 40, 14",
            "false, 50, 15",
            "false, 59, 15",
    })
    void norwegian_Blue_Parrot_Air_Speed_Velocity_Depends_On_Nailed_And_Voltage(
            boolean nailed, int voltage, int expectedSpeed) {

        // Given
        IBird bird = IBird.of(BirdDto.of(
                "es",
                NORWEGIAN_BLUE_PARROT,
                0,
                voltage,
                nailed));

        // When
        int airSpeedVelocity = bird.airSpeedVelocity();

        // Then
        assertThat(airSpeedVelocity).isEqualTo(expectedSpeed);
    }

    @ParameterizedTest
    @CsvSource({
            "10, NORWEGIAN_BLUE_PARROT",
            "0, NORWEGIAN_BLUE_PARROT",
            "80, NORWEGIAN_BLUE_PARROT",
            "90, NORWEGIAN_BLUE_PARROT",
            "100, NORWEGIAN_BLUE_PARROT",
            "101, SCORCHED",
            "111, SCORCHED",
            "150, SCORCHED"
    })
    void norwegian_Blue_Parrot_Has_Plumage_Depends_On_Voltage(
            int voltage, PlumageType expectedType) {

        // Given
        IBird bird = IBird.of(BirdDto.of(
                "es",
                NORWEGIAN_BLUE_PARROT,
                0,
                voltage,
                false));

        // When
        PlumageType actualPlumage = bird.plumage();

        // Then
        assertThat(actualPlumage).isEqualTo(expectedType);

    }

}///:~