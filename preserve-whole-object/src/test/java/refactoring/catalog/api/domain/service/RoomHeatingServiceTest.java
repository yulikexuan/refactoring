package refactoring.catalog.api.domain.service;


import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import refactoring.catalog.api.domain.model.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.never;
import static org.mutabilitydetector.unittesting.MutabilityAssert.assertImmutable;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test class RoomHeatingService - ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class RoomHeatingServiceTest {

    static final long PLAN_TEMP_LOW = 15;
    static final long PLAN_TEMP_HIGH = 25;

    private static final TempRange PLAN_TEMP_RANGE =
            TempRange.of(PLAN_TEMP_LOW, PLAN_TEMP_HIGH);

    private static HeatingPlan heatingPlanInit;
    private static HeatingPlan heatingPlanRefactor;

    @Mock
    private HeatingAlert heatingAlert;

    @Mock
    private HeatingCommand heatingCommand;

    private Room room;

    private RoomHeatingService roomHeatingService;

    @BeforeAll
    static void beforeAll() {
        heatingPlanInit = HeatingPlan.initPlan(PLAN_TEMP_RANGE);
        heatingPlanRefactor = HeatingPlan.refactorPlan(PLAN_TEMP_RANGE);
    }

    @BeforeEach
    void setUp() {
        this.roomHeatingService = RoomHeatingService.of(
                heatingPlanInit, heatingCommand, heatingAlert);
    }

    @Test
    void class_Room_Should_Be_Immutable() {
        assertImmutable(Room.class);
    }

    @Test
    void class_TempRange_Should_Be_Immutable() {
        assertImmutable(TempRange.class);
    }

    @ParameterizedTest
    @CsvSource({ "15, 25, true",
            "14, 25, false",
            "15, 26, false",
            "14, 26, false",
            "16, 24, true"
    })
    void able_To_Heat_A_Room_With_Init_Heating_Plan(long roomTempLow,
                                               long roomTempHigh,
                                               boolean heating) {

        // Given
        this.room = Room.of(TempRange.of(roomTempLow, roomTempHigh));

        // When & Then
        assertThatThrownBy(() -> this.roomHeatingService.heating(room))
                .isInstanceOf(IllegalCallerException.class);


        // Then
//        if (heating) {
//            then(this.heatingCommand).should().executeHeating();
//            then(this.heatingAlert).should(never()).alert(room);
//        } else {
//            then(this.heatingCommand).should(never()).executeHeating();
//            then(this.heatingAlert).should().alert(room);
//        }
    }

    @ParameterizedTest
    @CsvSource({ "15, 25, true",
            "14, 25, false",
            "15, 26, false",
            "14, 26, false",
            "16, 24, true"
    })
    void able_To_Heat_A_Room_With_Refactor_Heating_Plan(long roomTempLow,
                                                    long roomTempHigh,
                                                    boolean heating) {

        // Given
        this.roomHeatingService = RoomHeatingService.of(
                heatingPlanRefactor, heatingCommand, heatingAlert);

        this.room = Room.of(TempRange.of(roomTempLow, roomTempHigh));

        // When
        this.roomHeatingService.heating(room);


        // Then
        if (heating) {
            then(this.heatingCommand).should().executeHeating();
            then(this.heatingAlert).should(never()).alert(room);
        } else {
            then(this.heatingCommand).should(never()).executeHeating();
            then(this.heatingAlert).should().alert(room);
        }
    }

}///:~