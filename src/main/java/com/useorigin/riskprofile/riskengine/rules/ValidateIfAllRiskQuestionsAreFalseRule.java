package com.useorigin.riskprofile.riskengine.rules;

import com.useorigin.riskprofile.riskengine.domain.Insurance;
import com.useorigin.riskprofile.userprofile.IneligibleExepection;

public class ValidateIfAllRiskQuestionsAreFalseRule implements Rule {
    @Override
    public int calculateRule(Insurance variable) throws IneligibleExepection {
        if (variable.getUserProfile().getIncome() < Constants.INCOME_TO_BE_VALIDATE_PLUS_VALIDATION_OF_ALL_RISK_QUESTIONS){
            for (int question : variable.getUserProfile().getRiskQuestions()) {
                if (question == Constants.TRUE_VALUE_AS_INT) {
                    return DEFAULT_ANSWER;
                }
            }
        }else{
            return DEFAULT_ANSWER;
        }
        throw new IneligibleExepection();
    }
}
