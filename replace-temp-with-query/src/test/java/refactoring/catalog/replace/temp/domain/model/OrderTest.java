package refactoring.catalog.replace.temp.domain.model;


import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.internal.matchers.Or;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import static org.mutabilitydetector.unittesting.MutabilityAssert.assertImmutable;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test Order class - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class OrderTest {

    private ThreadLocalRandom random;

    @BeforeEach
    void setUp() {
        this.random = ThreadLocalRandom.current();
    }

    @Test
    void class_Order_Should_Be_Immutable() {
        assertImmutable(Item.class);
        assertImmutable(Order.class);
    }

    @ParameterizedTest
    @CsvSource({"79426, 99, 7470015",
            "59125, 32, 1797400",
            "63487, 84, 5066262",
            "71557, 56, 3806832",
            "60728, 79, 4557636",
            "86567, 82, 6743569",
            "88643, 24, 2021060"})
    void give_Base_Discount_If_Less_Than_Base_Price_Threshold(
            long price, int quantity, long expectedOrderPrice) {

        // Given
        String itemName = RandomStringUtils.randomAlphabetic(7);
        Item item = Item.of(itemName, price);
        Order order = Order.of(item, quantity);

        // When
        long actualOrderPrice = order.price();

        // Then
        assertThat(actualOrderPrice).isEqualTo(expectedOrderPrice);
    }

}///:~