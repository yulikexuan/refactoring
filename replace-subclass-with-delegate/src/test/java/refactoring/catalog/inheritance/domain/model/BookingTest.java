package refactoring.catalog.inheritance.domain.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import refactoring.catalog.inheritance.domain.model.refactor.BookingRefactor;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import static org.mockito.BDDMockito.given;
import static refactoring.catalog.inheritance.domain.model.OwningProperty.Property.DINNER;
import static refactoring.catalog.inheritance.domain.model.OwningProperty.Property.TALKBACK;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test Refactoring of class BookingRefactor - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class BookingTest {

    @Mock
    private Extras extras;

    @Mock
    private Show show;

    private BookingRefactor booking;

    private LocalDate date;

    @BeforeEach
    void setUp() {
    }

    @ParameterizedTest
    @CsvSource({ "false, 2023, 1, 4, false",
            "false, 2023, 1, 6, false",
            "false, 2023, 1, 7, false",
            "true, 2023, 1, 6, false",
            "true, 2023, 1, 7, false",
            "true, 2023, 1, 4, true",
            "true, 2023, 1, 5, true"})
    void booking_Has_Talkback(boolean showHasTalkback,
                              int year, int month, int day,
                              boolean expectedHavingTalkback) {

        // Given
        this.booking = Booking.of(this.show, LocalDate.of(year, month, day));

        given(this.show.hasOwnProperty(TALKBACK)).willReturn(showHasTalkback);

        // When
        boolean actualHavingTalkback = this.booking.hasTalkback();

        // Then
        assertThat(actualHavingTalkback).isEqualTo(expectedHavingTalkback);
    }

    @ParameterizedTest
    @CsvSource({ "false, 2023, 1, 4, false",
            "false, 2023, 1, 6, false",
            "false, 2023, 1, 7, false",
            "true, 2023, 1, 6, true",
            "true, 2023, 1, 7, true",
            "true, 2023, 1, 4, true",
            "true, 2023, 1, 5, true"})
    void premium_Booking_Has_More_Talkback(boolean showHasTalkback,
                                           int year, int month, int day,
                                           boolean expectedHavingTalkback) {

        // Given
        PremiumBooking premiumBooking = PremiumBooking.of(
                this.show, LocalDate.of(year, month, day), this.extras);

        given(this.show.hasOwnProperty(TALKBACK)).willReturn(showHasTalkback);

        // When
        boolean actualHavingTalkback = premiumBooking.hasTalkback();

        // Then
        assertThat(actualHavingTalkback).isEqualTo(expectedHavingTalkback);
    }

    @ParameterizedTest
    @CsvSource({ "100, 2023, 1, 4, 100",
            "100, 2023, 1, 6, 115",
            "100, 2023, 1, 7, 115",
            "100, 2023, 1, 5, 100"})
    void booking_Has_Regular_Base_Price(long showPrice,
                                        int year, int month, int day,
                                        long expectedPrice) {

        // Given
        this.booking = Booking.of(this.show, LocalDate.of(year, month, day));

        given(this.show.price()).willReturn(showPrice);

        // When
        long actualPrice = this.booking.basePrice();

        // Then
        assertThat(actualPrice).isEqualTo(expectedPrice);
    }

    @ParameterizedTest
    @CsvSource({ "100, 10, 2023, 1, 4, 110",
            "100, 20, 2023, 1, 5, 120",
            "100, 30, 2023, 1, 6, 145",
            "100, 15, 2023, 1, 7, 130"})
    void premium_Booking_Has_Expensive_Base_Price(long showPrice,
                                                  long premiumFee,
                                                  int year, int month, int day,
                                                  long expectedPrice) {

        // Given
        PremiumBooking premiumBooking = PremiumBooking.of(
                this.show, LocalDate.of(year, month, day), this.extras);

        given(this.show.price()).willReturn(showPrice);

        given(this.extras.premiumFee()).willReturn(premiumFee);

        // When
        long actualPrice = premiumBooking.basePrice();

        // Then
        assertThat(actualPrice).isEqualTo(expectedPrice);
    }

    @ParameterizedTest
    @CsvSource({ "true, 2023, 1, 4, true",
            "true, 2023, 1, 5, true",
            "true, 2023, 1, 6, false",
            "true, 2023, 1, 7, false",
            "false, 2023, 1, 4, false",
            "false, 2023, 1, 5, false",
            "false, 2023, 1, 6, false",
            "false, 2023, 1, 7, false"})
    void premium_Booking_Has_Dinner(boolean hasDinnerProperty,
                                    int year, int month, int day,
                                    boolean expectedHavingDinner) {

        // Given
        PremiumBooking bookingWithDinner =PremiumBooking.of(
                this.show, LocalDate.of(year, month, day), this.extras);

        given(this.extras.hasOwnProperty(DINNER)).willReturn(hasDinnerProperty);

        // When
        boolean actuallyHavingDinner = bookingWithDinner.hasDinner();

        // Then
        assertThat(actuallyHavingDinner).isEqualTo(expectedHavingDinner);
    }

}///:~