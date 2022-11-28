package refactoring.catalog.split.variable.domain.model;


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


@DisplayName("Test class HaggisGame - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class HaggisGameTest {

    private HaggisGame haggisGame;

    @BeforeEach
    void setUp() {
    }

    @ParameterizedTest
    @CsvSource({"20, 10, 12, 7, 60, 3204",
            "32, 12, 22, 11, 90, 7170",
            "32, 12, 40, 11, 90, 3120",
            "24, 10, 30, 11, 30, 180"})
    void able_To_Calculate_Travel_Distance(long primaryForce,
                                           long secondaryForce,
                                           long mass,
                                           long delay,
                                           long time,
                                           long expectedDistance) {

        // Given
        this.haggisGame = HaggisGame.of(primaryForce, secondaryForce, mass, delay);

        // When
        long actualDistance = haggisGame.getDistanceTravelled(time);

        // Then
        assertThat(actualDistance).isEqualTo(expectedDistance);
    }

}///:~