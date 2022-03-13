package com.useorigin.riskprofile.riskengine.rules;

import com.useorigin.riskprofile.riskengine.domain.Insurance;
import com.useorigin.riskprofile.userprofile.IneligibleExepection;
import com.useorigin.riskprofile.userprofile.enums.MaritalStatusEnum;

public class MarriedDisabilityRule implements Rule{
    @Override
    public int calculateRule(Insurance variable) throws IneligibleExepection {
        if (variable.getUserProfile().getMaritalStatus().equals(MaritalStatusEnum.MARRIED.getValue())){
            return Constants.MARRIED_DISABILITY_RULE_POINT;
        }
        return 0;
    }
}
