package refactoring.catalog.replace.variable.domain.model;


import com.google.common.collect.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import static org.mutabilitydetector.unittesting.MutabilityAssert.assertImmutable;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test class ProductionPlan - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class ProductionPlanTest {

    private ProductionPlan productionPlan;

    private ThreadLocalRandom random;

    private long initialProduction;

    @BeforeEach
    void setUp() {
        this.random = ThreadLocalRandom.current();
        this.initialProduction = this.random.nextLong(1000, 99999);
        this.productionPlan = new ProductionPlan(this.initialProduction);
        assertThat(this.productionPlan.production()).isEqualTo(this.initialProduction);
        assertThat(this.productionPlan.adjustments()).hasSize(0);
    }

    @Test
    void class_Adjustment_Should_Be_Immutable() {
        assertImmutable(Adjustment.class);
    }

    @Test
    void able_To_Record_And_Apply_Adjustment_To_Production() {

        // Given
        List<Adjustment> adjustments = IntStream.range(0, 10)
                .mapToObj(i -> Adjustment.of(
                        this.random.nextLong(1000, 99999),
                        LocalDate.now().plusDays(i)))
                .toList();

        long expectedTotalAmount = this.initialProduction + adjustments.stream()
                .mapToLong(Adjustment::amount)
                .sum();

        // When
        adjustments.stream().forEach(
                adj -> this.productionPlan.applyAdjustment(adj));

        final List<Adjustment> actualAdjustments =
                Lists.reverse(this.productionPlan.adjustments());

        // Then
        assertThat(this.productionPlan.production()).isEqualTo(expectedTotalAmount);
        assertThat(actualAdjustments).containsExactlyElementsOf(adjustments);
    }

}///:~