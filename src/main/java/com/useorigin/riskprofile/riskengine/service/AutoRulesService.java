package com.useorigin.riskprofile.riskengine.service;

import com.useorigin.riskprofile.riskengine.domain.AutoInsurance;
import com.useorigin.riskprofile.riskengine.domain.Insurance;
import com.useorigin.riskprofile.riskengine.enums.AutoRulesEnum;
import com.useorigin.riskprofile.riskengine.enums.InsurancePlanEnum;
import com.useorigin.riskprofile.userprofile.IneligibleExepection;
import com.useorigin.riskprofile.userprofile.request.UserProfileRequest;
import org.springframework.stereotype.Service;

@Service
public class AutoRulesService extends InsuranceRulesService {


    @Override
    protected int getRateFromProfile() throws IneligibleExepection {
        int rate = 0;
        Insurance auto = new AutoInsurance(userProfile);
        for (AutoRulesEnum rule : AutoRulesEnum.values()) {
            rate += rule.getValue().calculateRule(auto);
        }
        return rate;
    }
}
