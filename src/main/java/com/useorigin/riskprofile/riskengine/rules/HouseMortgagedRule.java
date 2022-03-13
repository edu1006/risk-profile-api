package com.useorigin.riskprofile.riskengine.rules;

import com.useorigin.riskprofile.riskengine.domain.Insurance;
import com.useorigin.riskprofile.riskengine.enums.OwnershipStatusEnum;
import com.useorigin.riskprofile.userprofile.IneligibleExepection;

public class HouseMortgagedRule implements  Rule
{
    @Override
    public int calculateRule(Insurance variable) throws IneligibleExepection {

        if(variable.getUserProfile().getHouse().getOwnership_status().toUpperCase().equals(OwnershipStatusEnum.MORTGAGED.toString())){
            return Constants.HOUSE_MORTGAGED_RULE_POINTS;
        }
        return Rule.DEFAULT_ANSWER;
    }
}
