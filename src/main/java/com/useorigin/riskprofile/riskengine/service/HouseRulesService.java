package com.useorigin.riskprofile.riskengine.service;

import com.useorigin.riskprofile.riskengine.domain.HouseInsurance;
import com.useorigin.riskprofile.riskengine.domain.Insurance;
import com.useorigin.riskprofile.riskengine.enums.HomeRulesEnum;
import com.useorigin.riskprofile.riskengine.enums.InsurancePlanEnum;
import com.useorigin.riskprofile.userprofile.IneligibleExepection;
import com.useorigin.riskprofile.userprofile.request.UserProfileRequest;
import org.springframework.stereotype.Service;

@Service
public class HouseRulesService extends InsuranceRulesService {

    @Override
    protected int getRateFromProfile() throws IneligibleExepection {

        int rate = 0;
        Insurance home = new HouseInsurance(userProfile);
        for (HomeRulesEnum rule : HomeRulesEnum.values()) {
            rate += rule.getValue().calculateRule(home);
        }
        return rate;
    }
}
