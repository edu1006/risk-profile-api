package com.useorigin.riskprofile.riskengine.service;

import com.useorigin.riskprofile.riskengine.domain.Insurance;
import com.useorigin.riskprofile.riskengine.domain.LifeInsurance;
import com.useorigin.riskprofile.riskengine.enums.InsurancePlanEnum;
import com.useorigin.riskprofile.riskengine.enums.LifeRulesEnum;
import com.useorigin.riskprofile.userprofile.IneligibleExepection;
import com.useorigin.riskprofile.userprofile.request.UserProfileRequest;
import org.springframework.stereotype.Service;

@Service
public class LifeRulesService extends InsuranceRulesService {

    @Override
    protected int getRateFromProfile() throws IneligibleExepection {
        int rate = 0;
        Insurance life = new LifeInsurance(userProfile);
        for (LifeRulesEnum rule : LifeRulesEnum.values()) {
            rate += rule.getValue().calculateRule(life);
        }
        return rate;
    }
}
