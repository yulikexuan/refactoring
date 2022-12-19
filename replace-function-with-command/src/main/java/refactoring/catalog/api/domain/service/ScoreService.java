//: refactoring.catalog.api.domain.service.ScoreService


package refactoring.catalog.api.domain.service;


import lombok.NonNull;
import refactoring.catalog.api.domain.model.Candidate;
import refactoring.catalog.api.domain.model.Grade;
import refactoring.catalog.api.domain.model.MedicalExam;
import refactoring.catalog.api.domain.model.ScoringGuide;

import static refactoring.catalog.api.domain.model.Grade.LOW;
import static refactoring.catalog.api.domain.model.Grade.REGULAR;


class ScoreService {

    static int score(
            @NonNull final Candidate candidate,
            @NonNull final MedicalExam medicalExam,
            @NonNull final ScoringGuide scoringGuide) {

        int result = 0;
        int healthLevel = 0;
        boolean highMedicalRiskFlag = false;

        if (medicalExam.isSmoker()) {
            healthLevel += 10;
            highMedicalRiskFlag = true;
        }

        Grade certificationGrade = REGULAR;

        if (scoringGuide.stateWithLowCertification(candidate.originState())) {
            certificationGrade = LOW;
            result -= 5;
        }

        result -= Math.max(healthLevel - 5, 0);

        return result;
    }

}///:~