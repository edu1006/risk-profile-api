package com.useorigin.riskprofile.riskengine.enums;

import com.useorigin.riskprofile.riskengine.rules.*;

/**
 * --auto
 *
 * 1)If the user doesn’t have income, vehicles or houses, she is ineligible for disability, auto,
 * and home insurance, respectively.
 *
 * 2)If the user is under 30 years old, deduct 2 risk points from all lines of insurance.
 * If she is between 30 and 40 years old, deduct 1.
 *
 * 3)If her income is above $200k, deduct 1 risk point from all lines of insurance.
 *
 * 4)If the user's vehicle was produced in the last 5 years, add 1 risk point to that vehicle’s score.
 */

public enum AutoRulesEnum {
   INELIGIBLE_RULE(new IneligibleRule()),
   VALIDATION_RISK_QUESTION_RULE(new ValidateIfAllRiskQuestionsAreFalseRule()),
   AGE_VALIDATION_RULE(new AgeValidationRule()),
   INCOME_ABOVE_TARGET_VALUE_RULE(new IncomeAboveTargetValueRule()),
   VEHICLE_YEAR_VALIDATION_RULE(new VehicleAgeRule());

   private Rule rule;
   private AutoRulesEnum(Rule rule){
      this.rule = rule;
   }
   public Rule getValue(){
      return this.rule;
   }

}
