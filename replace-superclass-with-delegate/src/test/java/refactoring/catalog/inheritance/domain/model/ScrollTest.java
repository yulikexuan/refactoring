package refactoring.catalog.inheritance.domain.model;


import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import refactoring.catalog.inheritance.domain.model.refactor.ScrollRefactor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;


@DisplayName("Test class Scroll - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class ScrollTest {

    private int id;

    private String title;

    private List<String> tags;

    private int year;
    private int month;
    private int day;

    private LocalDate dateLastCleaned;

    private int catalogId;

    private ICatalog catalogItem;

    private ScrollRefactor scroll;

    private ThreadLocalRandom random;

    @BeforeEach
    void setUp() {

        this.random = ThreadLocalRandom.current();
        this.id = this.random.nextInt(1000, 9999);
        this.catalogId = this.random.nextInt(1000, 9999);
        this.title = RandomStringUtils.randomAlphabetic(7);

        this.tags = List.of(RandomStringUtils.randomAlphabetic(4),
                RandomStringUtils.randomAlphabetic(4),
                RandomStringUtils.randomAlphabetic(4),
                RandomStringUtils.randomAlphabetic(4));

        this.catalogItem = new CatalogItem(this.catalogId, this.title, this.tags);

        this.year = 2023;
        this.month = 1;
        this.day = 5;

        this.dateLastCleaned = LocalDate.of(this.year, this.month, this.day);
    }

    @Test
    void scroll_Has_Tags() {

        // Given
        this.scroll = new ScrollRefactor(id, catalogItem, dateLastCleaned);

        // When
        String aTag = UUID.randomUUID().toString();

        // Then
        assertThat(this.scroll.hasTag(aTag)).isFalse();

        this.tags.stream().forEach(t -> assertThat(this.scroll.hasTag(t)).isTrue());
    }

    @ParameterizedTest
    @CsvSource({"true, 2024, 1, 5, false",
            "true, 2025, 1, 5, true",
            "false, 2027, 2, 13, false",
            "false, 2027, 2, 14, true",
            "false, 2028, 1, 5, true"})
    void knows_When_To_Clean(boolean revered,
                             int targetY,
                             int targetM,
                             int targetD,
                             boolean expectedNeeds) {

        // Given
        this.tags =  (revered) ? List.of("revered") : this.tags;
        this.catalogItem = new CatalogItem(this.catalogId, this.title, this.tags);

        this.scroll = new ScrollRefactor(id, catalogItem, dateLastCleaned);

        // When
        boolean actualNeeds = this.scroll.needsCleaning(
                LocalDate.of(targetY, targetM, targetD));

        // Then
        assertThat(actualNeeds).isEqualTo(expectedNeeds);
    }

}///:~