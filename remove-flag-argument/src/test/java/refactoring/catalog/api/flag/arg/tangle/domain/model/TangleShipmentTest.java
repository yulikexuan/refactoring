package refactoring.catalog.api.flag.arg.tangle.domain.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;
import refactoring.catalog.api.flag.arg.domain.model.Order;
import refactoring.catalog.api.flag.arg.domain.model.State;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;


@DisplayName("Test refactoring.catalog.api.flag.arg.tangle.domain.model.ITangleShipment- ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class TangleShipmentTest {

    private ITangleShipment tangleShipmentInit;

    private Order order;

    @BeforeEach
    void setUp() {
        this.tangleShipmentInit = new TangleShipmentInit();
    }

    @ParameterizedTest
    @CsvSource({
            "true, MA, 2022-11-10, 2022-11-12",
            "false, MA, 2022-11-10, 2022-11-14",
            "true, CT, 2022-11-10, 2022-11-12",
            "false, CT, 2022-11-10, 2022-11-14",
            "true, NY, 2022-11-10, 2022-11-13",
            "false, NY, 2022-11-10, 2022-11-14",
            "true, NH, 2022-11-10, 2022-11-13",
            "false, NH, 2022-11-10, 2022-11-15",
            "true, ME, 2022-11-10, 2022-11-14",
            "false, ME, 2022-11-10, 2022-11-15",
            "true, GA, 2022-11-10, 2022-11-14",
            "false, GA, 2022-11-10, 2022-11-16",
            "true, IL, 2022-11-10, 2022-11-14",
            "false, IL, 2022-11-10, 2022-11-16"
    })
    void able_To_Calculate_Delivery_Date_For_Order(boolean rush,
                                                   State deliveryState,
                                                   LocalDate placeOn,
                                                   LocalDate expectedDeliveryDate) {

        // Given
        this.order = Order.of(deliveryState, placeOn);

        // When
        LocalDate actualDeliveryDateInit =
                this.tangleShipmentInit.deliveryDate(order, rush);

        // Then
        assertThat(actualDeliveryDateInit).isEqualTo(expectedDeliveryDate);
    }

}///:~