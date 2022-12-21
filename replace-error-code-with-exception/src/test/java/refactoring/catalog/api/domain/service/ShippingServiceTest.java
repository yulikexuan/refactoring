package refactoring.catalog.api.domain.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import refactoring.catalog.api.domain.model.Order;
import refactoring.catalog.api.domain.model.OrderError;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import static org.mockito.BDDMockito.given;
import static refactoring.catalog.api.domain.service.ShippingRuleService.LOCAL_SHIPPING_RULE_ERROR_CODE;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test class ShippingService - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class ShippingServiceTest {

    @Mock
    private Order order;

    private String[] countries;

    private Map<String, Integer> shippingRules;

    private IShippingRuleService ruleService;

    private IShippingRuleService ruleServiceRefactor;

    private ShippingCostService costService;

    private ShippingCostService costServiceRefactor;

    private IShippingService shippingService;

    private IShippingService shippingServiceRefactor;

    private ThreadLocalRandom random;

    @BeforeEach
    void setUp() {
        this.random = ThreadLocalRandom.current();
        this.countries = new String[] {
                "AF", "BR", "CA", "DK", "FR", "GR", "US", "JP"};
        this.shippingRules = Arrays.stream(countries).collect(Collectors.toMap(
                value -> value, value -> random.nextInt(10, 99)));
        this.ruleService = ShippingRuleService.of(this.shippingRules);
        this.ruleServiceRefactor = ShippingRuleServiceRefactor.of(this.shippingRules);
        this.costService = ShippingCostService.of(this.ruleService);
        this.costServiceRefactor = ShippingCostService.of(ruleServiceRefactor);
        this.shippingService = ShippingService.of(this.costService);
        this.shippingServiceRefactor = ShippingServiceRefactor.of(costServiceRefactor);
    }

    @Test
    void able_To_Handle_Invalid_Order() {

        // Given
        given(order.country()).willReturn("---");

        // When
        this.shippingService.shipping(this.order);
        List<OrderError> errors = this.shippingService.errorList();

        // Then
        assertThat(errors).containsExactly(OrderError.of(
                this.order, LOCAL_SHIPPING_RULE_ERROR_CODE));
    }

    @Test
    void able_To_Handle_Invalid_Order_As_Exception() {

        // Given
        given(order.country()).willReturn("---");

        // When
        this.shippingServiceRefactor.shipping(this.order);
        List<OrderError> errors = this.shippingServiceRefactor.errorList();

        // Then
        assertThat(errors).containsExactly(OrderError.of(
                this.order, LOCAL_SHIPPING_RULE_ERROR_CODE));
    }

}///:~