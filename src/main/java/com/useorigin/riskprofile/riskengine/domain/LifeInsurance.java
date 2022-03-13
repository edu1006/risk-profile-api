package com.useorigin.riskprofile.riskengine.domain;

import com.useorigin.riskprofile.userprofile.request.UserProfileRequest;

public class LifeInsurance implements Insurance {

    private UserProfileRequest userProfile;

    public LifeInsurance(UserProfileRequest userProfile){
        this.userProfile = userProfile;

    }

    @Override
    public Boolean hasInsuranceVariableToBeCalculated() {
        return false;
    }

    @Override
    public UserProfileRequest getUserProfile() {
        return this.userProfile;
    }
}
