package refactoring.catalog.replace.loop.domain.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test class Office - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class OfficeTest {

    static final String OFFICE_DATA = """
            office, country, telephone
            Chicago, USA, +1 312 373 1000
            Beijing, China, +86 4008 900 505
            Bangalore, India, +91 80 4064 9570
            Porto Alegre, Brazil, +55 51 3079 3550
            Chennai, India, +91 44 660 44766
            Montreal, Canada, +1 514-123-4567
            New York, USA, +1 646 777 9999
            """;

    @BeforeEach
    void setUp() {
    }

    @ParameterizedTest
    @CsvSource({"India, 2", "Canada, 1", "USA, 2", "Brazil, 1", "China, 1"})
    void able_To_Parse_A_String_As_Input_To_Generate_Office_Instances(
            String targetCountry, int expectedOfficeAmt) {

        // Given

        // When
        List<Office> offices = Office.parse(OFFICE_DATA, targetCountry);

        long actualOfficeAmtForCountry = offices.stream()
                .map(Office::country)
                .filter(c -> targetCountry.equals(c))
                .count();

        // Then
        assertThat(actualOfficeAmtForCountry).isEqualTo(expectedOfficeAmt);
    }

}///:~