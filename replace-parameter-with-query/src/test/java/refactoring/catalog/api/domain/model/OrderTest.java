package refactoring.catalog.api.domain.model;


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


@DisplayName("Test class OrderRefactor- ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class OrderTest {

    private OrderRefactor order;

    @BeforeEach
    void setUp() {

    }

    @ParameterizedTest
    @CsvSource({ "10, 1000, 9500",
            "30, 499, 14221",
            "12, 356, 4058",
    })
    void able_To_Calc_Final_Price_Of_Order(int quantity,
                                           long itemPrice,
                                           long expectedFinalPrice) {

        // Given
        this.order = OrderRefactor.of(quantity, itemPrice);

        // When
        long actualFinalPrice = this.order.finalPrice();

        // Then
        assertThat(actualFinalPrice).isEqualTo(expectedFinalPrice);
    }

}///:~