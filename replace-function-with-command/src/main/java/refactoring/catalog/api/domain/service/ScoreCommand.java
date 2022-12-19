//: refactoring.catalog.api.domain.service.ScoreCommand


package refactoring.catalog.api.domain.service;


import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import refactoring.catalog.api.domain.model.Candidate;
import refactoring.catalog.api.domain.model.Grade;
import refactoring.catalog.api.domain.model.MedicalExam;
import refactoring.catalog.api.domain.model.ScoringGuide;

import static refactoring.catalog.api.domain.model.Grade.LOW;
import static refactoring.catalog.api.domain.model.Grade.REGULAR;


@Accessors(fluent = true)
@RequiredArgsConstructor(staticName = "of")
public class ScoreCommand {

    @NonNull
    private final Candidate candidate;

    @NonNull
    private final MedicalExam medicalExam;

    @NonNull
    private final ScoringGuide scoringGuide;

    private int result = 0;

    private int healthLevel = 0;

    private boolean highMedicalRiskFlag = false;

    private Grade certificationGrade;

    public int execute() {

        this.result = 0;
        this.healthLevel = 0;
        this.highMedicalRiskFlag = false;

        this.scoreSmoking();

        this.certificationGrade = REGULAR;
        this.scoreWithGuide();

        this.result -= Math.max(healthLevel - 5, 0);

        return this.result;
    }

    void scoreWithGuide() {
        if (this.scoringGuide.stateWithLowCertification(
                this.candidate.originState())) {

            this.certificationGrade = LOW;
            this.result -= 5;
        }
    }

    void scoreSmoking() {
        if (this.medicalExam.isSmoker()) {
            this.healthLevel += 10;
            this.highMedicalRiskFlag = true;
        }
    }

}///:~