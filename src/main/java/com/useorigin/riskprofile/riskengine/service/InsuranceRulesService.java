package com.useorigin.riskprofile.riskengine.service;

import com.useorigin.riskprofile.riskengine.enums.InsurancePlanEnum;
import com.useorigin.riskprofile.userprofile.IneligibleExepection;
import com.useorigin.riskprofile.userprofile.request.UserProfileRequest;

import java.util.Arrays;

public abstract class InsuranceRulesService {
    protected UserProfileRequest userProfile;
    public InsurancePlanEnum calculateInsurancePlan(UserProfileRequest userProfile){
        this.userProfile = userProfile;

        try {
            int rate = sumRiskQuestions(userProfile.getRiskQuestions());
            rate += getRateFromProfile();
            return InsurancePlanEnum.getInsurancePlanByRate(rate);

        } catch (IneligibleExepection e) {
            return InsurancePlanEnum.INELIGIBLE;
        }
    }

    protected abstract int getRateFromProfile() throws IneligibleExepection;

    private int sumRiskQuestions(Integer[] questions) throws IneligibleExepection {
        if (questions == null) {
            throw new IneligibleExepection();
        }
        return Arrays.stream(questions).mapToInt(Integer::intValue).sum();
    }
}
