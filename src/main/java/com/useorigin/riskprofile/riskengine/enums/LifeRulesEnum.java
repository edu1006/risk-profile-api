package com.useorigin.riskprofile.riskengine.enums;

import com.useorigin.riskprofile.riskengine.rules.*;

public enum LifeRulesEnum {

   AGE_VALIDATION_ABOVE_TARGET_VALUE(new AgeValidationAboveTargetValueRule()),
   AGE_VALIDATION_RULE(new AgeValidationRule()),
   INCOME_ABOVE_TARGET_VALUE_RULE(new IncomeAboveTargetValueRule()),
   DEPENDS_RULE(new UserDependentsRule()),
   MARRIGIED_RULE(new MarriedLifeRule());

   private Rule rule;
   private LifeRulesEnum(Rule rule){
      this.rule = rule;
   }
   public Rule getValue(){
      return this.rule;
   }

}
