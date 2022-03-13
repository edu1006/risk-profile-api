package com.useorigin.riskprofile.riskengine.domain;

import com.useorigin.riskprofile.userprofile.request.UserProfileRequest;

public class DisabilityInsurance implements  Insurance{
    private UserProfileRequest userProfile;

    public DisabilityInsurance(UserProfileRequest userProfile){
        this.userProfile = userProfile;
    }
    @Override
    public Boolean hasInsuranceVariableToBeCalculated() {

        if(this.userProfile.getIncome() != null && this.userProfile.getIncome() > 0 ){
            return true;
        }
        return false;
    }

    @Override
    public UserProfileRequest getUserProfile() {
        return this.userProfile;
    }
}
