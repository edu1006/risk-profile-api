package com.useorigin.riskprofile.riskengine.domain;

import com.useorigin.riskprofile.userprofile.request.UserProfileRequest;
import com.useorigin.riskprofile.userprofile.response.RiskProfileResponse;

public class UmbrellaInsurance implements  IUmbrellaInsurance{

    private UserProfileRequest userProfile;
    private RiskProfileResponse riskProfileResponse;
    public UmbrellaInsurance(UserProfileRequest userProfile, RiskProfileResponse riskProfileResponse){
        this.userProfile = userProfile;
        this.riskProfileResponse = riskProfileResponse;

    }


    @Override
    public RiskProfileResponse getRiskProfileResponse() {
        return riskProfileResponse;
    }

    @Override
    public Boolean hasInsuranceVariableToBeCalculated() {
        return Boolean.FALSE;
    }

    @Override
    public UserProfileRequest getUserProfile() {
        return this.userProfile;
    }
}
