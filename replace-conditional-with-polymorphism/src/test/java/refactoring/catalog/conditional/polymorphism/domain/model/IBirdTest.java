package refactoring.catalog.conditional.polymorphism.domain.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;


@DisplayName("Test interface IBird - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class IBirdTest {

    private IBird bird;

    @BeforeEach
    void setUp() {
    }

    @ParameterizedTest
    @CsvSource({ "Bird_1, EUROPEAN_SWALLOW, 100, 2, true, AVERAGE",
            "Bird_2, EUROPEAN_SWALLOW, 100, 3, true, AVERAGE",
            "Bird_3, EUROPEAN_SWALLOW, 101, 2, true, AVERAGE",
            "Bird_4, AFRICAN_SWALLOW, 100, 3, true, TIRED",
            "Bird_5, AFRICAN_SWALLOW, 100, 2, true, AVERAGE",
            "Bird_6, NORWEGIAN_BLUE_PARROT, 101, 2, true, SCORCHED",
            "Bird_7, NORWEGIAN_BLUE_PARROT, 100, 2, true, BEAUTIFUL",
            "Bird_8, PEACOCK, 100, 2, true, UNKNOWN",})
    void able_To_Describe_The_Plumage_Of_A_Bird(String name,
                                                IBird.Type type,
                                                int voltage,
                                                int numberOfCoconuts,
                                                boolean nailed,
                                                IBird.PLUMAGE expectedPlumage) {

        // Given
        this.bird = Bird.of(name, type, voltage, numberOfCoconuts, nailed);

        // When
        IBird.PLUMAGE actualPlumage = this.bird.plumage();

        // Then
        assertThat(actualPlumage).isSameAs(expectedPlumage);
    }

    @ParameterizedTest
    @CsvSource({ "Bird_1, EUROPEAN_SWALLOW, 100, 2, true, 35",
            "Bird_2, AFRICAN_SWALLOW, 100, 1, true, 38",
            "Bird_3, AFRICAN_SWALLOW, 100, 20, true, 0",
            "Bird_4, AFRICAN_SWALLOW, 100, 12, true, 16",
            "Bird_5, NORWEGIAN_BLUE_PARROT, 100, 12, true, 0",
            "Bird_6, NORWEGIAN_BLUE_PARROT, 100, 12, false, 20",
            "Bird_7, NORWEGIAN_BLUE_PARROT, 50, 12, false, 15",
            "Bird_8, PEACOCK, 50, 12, false, -1"})
    void able_To_Know_The_Speed_Of_A_Bird(String name,
                                          IBird.Type type,
                                          int voltage,
                                          int numberOfCoconuts,
                                          boolean nailed,
                                          int expectedSpeed) {
        // Given
        this.bird = Bird.of(name, type, voltage, numberOfCoconuts, nailed);

        // When
        int actualSpeed = this.bird.airSpeedVelocity();

        // Then
        assertThat(actualSpeed).isSameAs(expectedSpeed);
    }

}///:~