package refactoring.catalog.replace.primitive.domain.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import refactoring.catalog.replace.primitive.domain.model.Order;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test OrdersService Class - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class OrdersServiceTest {

    static final int EXPECTED_HIGH_PRIORITY_COUNT = 3;

    private List<Order> orders;

    @BeforeEach
    void setUp() {
        this.orders = List.of(
                Order.of(UUID.randomUUID().toString(), "normal"),
                Order.of(UUID.randomUUID().toString(), "high"),
                Order.of(UUID.randomUUID().toString(), "high"),
                Order.of(UUID.randomUUID().toString(), "medium"),
                Order.of(UUID.randomUUID().toString(), "rush"),
                Order.of(UUID.randomUUID().toString(), "low"));
    }

    @Test
    void able_To_Count_High_Priority_Orders() {

        // Given

        // When
        long actualNumOfHighPriorityOrders =
                OrdersService.countHighPriorityOrders(this.orders);

        // Then
        assertThat(actualNumOfHighPriorityOrders)
                .isEqualTo(EXPECTED_HIGH_PRIORITY_COUNT);
    }

}///:~