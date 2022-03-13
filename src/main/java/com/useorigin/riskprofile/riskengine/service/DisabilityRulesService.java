package com.useorigin.riskprofile.riskengine.service;

import com.useorigin.riskprofile.riskengine.domain.DisabilityInsurance;
import com.useorigin.riskprofile.riskengine.domain.HouseInsurance;
import com.useorigin.riskprofile.riskengine.domain.Insurance;
import com.useorigin.riskprofile.riskengine.enums.DisabilityRulesEnum;
import com.useorigin.riskprofile.riskengine.enums.HomeRulesEnum;
import com.useorigin.riskprofile.riskengine.enums.InsurancePlanEnum;
import com.useorigin.riskprofile.userprofile.IneligibleExepection;
import com.useorigin.riskprofile.userprofile.request.UserProfileRequest;
import org.springframework.stereotype.Service;

@Service
public class DisabilityRulesService extends InsuranceRulesService {

    @Override
    protected int getRateFromProfile() throws IneligibleExepection {
        int rate = 0;
        Insurance home = new DisabilityInsurance(userProfile);
        for (DisabilityRulesEnum rule : DisabilityRulesEnum.values()) {
            rate += rule.getValue().calculateRule(home);

        }
        return rate;
    }
}
