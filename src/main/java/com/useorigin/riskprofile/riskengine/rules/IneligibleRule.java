package com.useorigin.riskprofile.riskengine.rules;

import com.useorigin.riskprofile.riskengine.domain.Insurance;
import com.useorigin.riskprofile.userprofile.IneligibleExepection;

public class IneligibleRule implements Rule {


    @Override
    public int calculateRule(Insurance variable) throws IneligibleExepection {
        if ((variable == null) || !variable.hasInsuranceVariableToBeCalculated()) {
            throw new IneligibleExepection();
        }
        return Rule.DEFAULT_ANSWER;
    }
}
