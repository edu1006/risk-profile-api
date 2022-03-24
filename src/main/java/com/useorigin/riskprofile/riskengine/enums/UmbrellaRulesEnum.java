package com.useorigin.riskprofile.riskengine.enums;

import com.useorigin.riskprofile.riskengine.rules.*;

public enum UmbrellaRulesEnum {
    VALIDATE_IF_UMBRELLA_RULE_IS_ABLE_TO_BE_USED(new ValidateIsImbrellaServiceIsAble()),
    VALIDATION_RISK_QUESTION_RULE(new ValidateIfAllRiskQuestionsAreFalseRule()),
    AGE_VALIDATION_RULE(new AgeValidationRule()),
    INCOME_ABOVE_TARGET_VALUE_RULE(new IncomeAboveTargetValueRule());

    private Rule rule;
    private UmbrellaRulesEnum(Rule rule){
        this.rule = rule;
    }
    public Rule getValue(){
        return this.rule;
    }

}
