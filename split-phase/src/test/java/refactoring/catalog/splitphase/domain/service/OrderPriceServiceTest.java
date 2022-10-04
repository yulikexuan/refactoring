package refactoring.catalog.splitphase.domain.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;
import refactoring.catalog.splitphase.domain.model.Product;
import refactoring.catalog.splitphase.domain.model.ShippingMethod;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import static org.mutabilitydetector.unittesting.MutabilityAssert.assertImmutable;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test OrderPriceService Implementation - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class OrderPriceServiceTest {

    private OrderPriceService orderPriceService;

    @BeforeEach
    void setUp() {
        assertImmutable(Product.class);
        assertImmutable(ShippingMethod.class);
        this.orderPriceService = new OrderPriceServiceImpl();
    }

    @ParameterizedTest
    @CsvSource({"400, 7, 5, 700, 300, 500, 10, 6940",
            "250, 10, 3, 1000, 150, 300, 7, 2800",
            "700, 5, 6, 4000, 500, 800, 3, 4500"})
    void able_To_Calculate_The_Final_Price_Of_Product(
            int basePrice, int discountThreshold, int discountRate,
            int shippingDiscountThreshold, int shippingDiscountFee,
            int feePerShippingCase, int quantity, int expectedFinalPrice) {

        // Given
        final Product product = Product.of(basePrice, discountThreshold, discountRate);

        final ShippingMethod shippingMethod = ShippingMethod.of(
                shippingDiscountThreshold, shippingDiscountFee, feePerShippingCase);

        // When
        int finalPrice = this.orderPriceService.priceOrder(
                product, quantity, shippingMethod);

        // Then
        assertThat(finalPrice).isEqualTo(expectedFinalPrice);
    }

}///:~