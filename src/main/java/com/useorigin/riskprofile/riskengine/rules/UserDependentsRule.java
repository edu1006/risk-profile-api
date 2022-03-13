package com.useorigin.riskprofile.riskengine.rules;

import com.useorigin.riskprofile.riskengine.domain.Insurance;
import com.useorigin.riskprofile.userprofile.IneligibleExepection;

public class UserDependentsRule  implements Rule{
    @Override
    public int calculateRule(Insurance variable) throws IneligibleExepection {
        if (variable.getUserProfile().getDependents() >= Constants.USER_DEPENDENS_QUANTITY_ABOVE_VALIDATION)
            return Constants.USER_DEPENDENTS_RULE_POINTS;
        return Rule.DEFAULT_ANSWER;
    }
}
