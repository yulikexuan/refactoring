package refactoring.catalog.api.flag.arg.domain.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test class Shipment - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class ShipmentTest {

    private Order order;

    private IShipment shipmentInit;

    private IShipment shipmentAdvanced;

    private IShipmentRefactor shipmentFinal;

    @BeforeEach
    void setUp() {
        this.shipmentInit = new ShipmentInit();
        this.shipmentAdvanced = new ShipmentRefactor();
        this.shipmentFinal = new ShipmentFinal();
    }

    @ParameterizedTest
    @CsvSource({
            "true, MA, 2022-11-10, 2022-11-13",
            "false, MA, 2022-11-10, 2022-11-14",
            "true, CT, 2022-11-10, 2022-11-13",
            "false, CT, 2022-11-10, 2022-11-14",
            "true, NY, 2022-11-10, 2022-11-14",
            "false, NY, 2022-11-10, 2022-11-14",
            "true, NH, 2022-11-10, 2022-11-14",
            "false, NH, 2022-11-10, 2022-11-15",
            "true, ME, 2022-11-10, 2022-11-15",
            "false, ME, 2022-11-10, 2022-11-15",
            "true, IL, 2022-11-10, 2022-11-15",
            "false, IL, 2022-11-10, 2022-11-16"})
    void able_To_Calculate_Delivery_Date(boolean rush,
                                         State deliveryState,
                                         LocalDate placeOn,
                                         LocalDate expectedDeliveryDate) {

        // Given
        this.order = Order.of(deliveryState, placeOn);

        // When
        LocalDate actualDeliveryDateInit =
                this.shipmentInit.deliveryDate(order, rush);

        LocalDate actualDeliveryDateRefactor =
                this.shipmentAdvanced.deliveryDate(order, rush);

        LocalDate actualFinalDeliveryDate = rush ?
                this.shipmentFinal.rushDelivery(order) :
                this.shipmentFinal.regularDelivery(order);

        // Then
        assertThat(actualDeliveryDateInit).isEqualTo(expectedDeliveryDate);
        assertThat(actualDeliveryDateRefactor).isEqualTo(expectedDeliveryDate);
        assertThat(actualFinalDeliveryDate).isEqualTo(expectedDeliveryDate);
    }

}///:~