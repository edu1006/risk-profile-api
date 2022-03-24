package com.useorigin.riskprofile.riskengine.service;

import com.useorigin.riskprofile.riskengine.domain.IUmbrellaInsurance;
import com.useorigin.riskprofile.riskengine.domain.UmbrellaInsurance;
import com.useorigin.riskprofile.riskengine.enums.UmbrellaRulesEnum;
import com.useorigin.riskprofile.userprofile.IneligibleExepection;
import org.springframework.stereotype.Service;


@Service
public class UmbrellaRulesService extends InsuranceRulesService{
    @Override
    protected int getRateFromProfile() throws IneligibleExepection {
        int rate = 0;
        IUmbrellaInsurance umbrela = new UmbrellaInsurance(super.userProfile, super.riskProfileResponse);
        for (UmbrellaRulesEnum rule : UmbrellaRulesEnum.values()) {
            rate += rule.getValue().calculateRule(umbrela);
        }
        return rate;    }
}
