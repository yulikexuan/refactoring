package refactoring.catalog.api.domain.service;


import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import refactoring.catalog.api.domain.model.Candidate;
import refactoring.catalog.api.domain.model.MedicalExam;
import refactoring.catalog.api.domain.model.ScoringGuide;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test refactoring.catalog.api.domain.service.ScoreService- ")
@DisplayNameGeneration(ReplaceUnderscores.class)
class ScoreServiceTest {

    @Mock
    private Candidate candidate;

    @Mock
    private MedicalExam medicalExam;

    @Mock
    private ScoringGuide scoringGuide;

    private ScoreCommand scoreCommand;

    @BeforeEach
    void setUp() {
        this.scoreCommand = ScoreCommand.of(
                this.candidate, this.medicalExam, this.scoringGuide);
    }

    @ParameterizedTest
    @CsvSource({ "true, true, -10",
            "true, false, -5",
            "false, true, -5",
            "false, false, 0"})
    void test_Health_Score_Points_Calculation(boolean isSmoker,
                                              boolean stateWithLowCert,
                                              int expectedScore) {

        // Given
        given(this.medicalExam.isSmoker()).willReturn(isSmoker);

        String originState = RandomStringUtils.random(7);
        given(this.candidate.originState()).willReturn(originState);

        given(this.scoringGuide.stateWithLowCertification(originState))
                .willReturn(stateWithLowCert);

        // When
        int actualScore = ScoreService.score(candidate, medicalExam, scoringGuide);
        int actualScoreByCommand = this.scoreCommand.execute();

        // Then
        assertThat(actualScore).isEqualTo(expectedScore);
        assertThat(actualScoreByCommand).isEqualTo(expectedScore);
    }

}///:~