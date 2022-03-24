package com.useorigin.riskprofile.riskengine.service;

import com.useorigin.riskprofile.userprofile.IneligibleExepection;

public class UmbrellaRulesService extends InsuranceRulesService{
    @Override
    protected int getRateFromProfile() throws IneligibleExepection {
        return 0;
    }
}
