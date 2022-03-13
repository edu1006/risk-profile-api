package com.useorigin.riskprofile.riskengine.rules;

import com.useorigin.riskprofile.riskengine.domain.Insurance;
import com.useorigin.riskprofile.userprofile.IneligibleExepection;

public class IncomeAboveTargetValueRule implements Rule{

    @Override
    public int calculateRule(Insurance variable) throws IneligibleExepection {
        if (variable.getUserProfile().getIncome()> Constants.TARGET_INCOME){
            return Constants.POINT_INCOME_VALIDATION_DEDUCT;
        }
        return 0;
    }
}
