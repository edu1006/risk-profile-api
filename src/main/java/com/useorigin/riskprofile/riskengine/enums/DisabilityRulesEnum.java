package com.useorigin.riskprofile.riskengine.enums;

import com.useorigin.riskprofile.riskengine.rules.*;

public enum DisabilityRulesEnum {
    INELIGIBLE_RULE(new IneligibleRule()),
    AGE_ABOVE_TARGET_VALUE_RULE(new AgeValidationAboveTargetValueRule()),
    AGE_VALIDATION_RULE(new AgeValidationRule()),
    INCOME__RULES_ENUM(new IncomeAboveTargetValueRule()),
    MARRIED_RULE(new MarriedDisabilityRule()),
    DEPENDS_RULE(new UserDependentsRule()),
    VALIDATION_ON_RISK_QUESTION_TARGET(new SecondAnwerOnRiskQuestionRule());

    private Rule rule;

    private DisabilityRulesEnum(Rule rule) {
        this.rule = rule;
    }

    public Rule getValue() {
        return this.rule;
    }
}
