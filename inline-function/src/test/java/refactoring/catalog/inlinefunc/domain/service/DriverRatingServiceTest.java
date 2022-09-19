package refactoring.catalog.inlinefunc.domain.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import refactoring.catalog.inlinefunc.domain.model.Driver;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;


@DisplayName("Test StatementService - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class DriverRatingServiceTest {

    private Driver driver;

    private DriverRatingService driverRatingService;

    @BeforeEach
    void setUp() {
        this.driverRatingService = new DriverRatingService();
    }

    @ParameterizedTest
    @CsvSource({"0,1", "2,1", "3,1", "4,1", "5,1", "6,2", "7,2", "8,2", "9,2", "15,2",
            "66,2", "150,2", "1000,2"})
    void test_Driver_Rating(int numberOfLateDeliveries, int expectedRating) {

        // Given
        final Driver driver = Driver.of(numberOfLateDeliveries);

        // When
        int rating = this.driverRatingService.ratingDriver(driver);

        // Then
        assertThat(rating).isEqualTo(expectedRating);
    }

}