package com.useorigin.riskprofile.riskengine.rules;

import com.useorigin.riskprofile.riskengine.domain.Insurance;
import com.useorigin.riskprofile.userprofile.IneligibleExepection;

public class SecondAnwerOnRiskQuestionRule implements Rule{

    @Override
    public int calculateRule(Insurance variable) throws IneligibleExepection {
        boolean questionToBeValidated  = variable.getUserProfile().getRiskQuestions()[Constants.POSITION_TO_BE_VALIDATE] == 1 ? Boolean.TRUE: Boolean.FALSE;
        if (questionToBeValidated) {
            return Constants.VALUE_TO_BE_ADD_ON_RISK_ANWER_RULE;
        }
        return DEFAULT_ANSWER;
    }
}
