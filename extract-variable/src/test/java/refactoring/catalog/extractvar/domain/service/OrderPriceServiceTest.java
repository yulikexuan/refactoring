package refactoring.catalog.extractvar.domain.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;
import refactoring.catalog.extractvar.domain.model.Order;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test StatementService - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class OrderPriceServiceTest {

    private Order order;

    private OrderPriceService orderPriceService;

    @BeforeEach
    void setUp() {
        this.orderPriceService = new OrderPriceService();
    }

    @ParameterizedTest
    @CsvSource({"100, 1234, 133400", "200, 1234, 256800", "500, 1234, 627000",
            "501, 1234, 625766", "600, 1234, 503600", "700, 1234, 380200"})
    void order_Price_Should_Be_Base_Price_Minus_Quantity_Discount_Plus_Shipping(
            long quantity, long itemPrice, long expectedOrderPrice) {

        // Given
        this.order = Order.of(quantity, itemPrice);

        // When
        long orderPrice = this.orderPriceService.getOrderPrice(order);

        // Then
        assertThat(orderPrice).isEqualTo(expectedOrderPrice);
    }

}