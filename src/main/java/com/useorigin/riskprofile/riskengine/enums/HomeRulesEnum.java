package com.useorigin.riskprofile.riskengine.enums;

import com.useorigin.riskprofile.riskengine.rules.*;

public enum HomeRulesEnum {

    INELIGIBLE_RULE(new IneligibleRule()),
    VALIDATION_RISK_QUESTION_RULE(new ValidateIfAllRiskQuestionsAreFalseRule()),

    AGE_VALIDATION_RULE(new AgeValidationRule()),
    INCOME_ABOVE_TARGET_VALUE_RULE(new IncomeAboveTargetValueRule()),
    HOUSE_MORTGAGED_RULE(new HouseMortgagedRule());
    private Rule rule;

    private HomeRulesEnum(Rule rule) {
        this.rule = rule;
    }

    public Rule getValue() {
        return this.rule;

    }

}
