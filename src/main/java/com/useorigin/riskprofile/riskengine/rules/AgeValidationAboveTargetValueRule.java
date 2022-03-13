package com.useorigin.riskprofile.riskengine.rules;

import com.useorigin.riskprofile.riskengine.domain.Insurance;
import com.useorigin.riskprofile.userprofile.IneligibleExepection;

public class AgeValidationAboveTargetValueRule implements Rule{
    @Override
    public int calculateRule(Insurance variable) throws IneligibleExepection {
        if (variable.getUserProfile().getAge() > Constants.TAGET_AGE_VALIDATION_RULE_ABOVE_TARGET_VALUE){
            throw new IneligibleExepection();
        }
        return 0;
    }
}
