package com.useorigin.riskprofile.riskengine.domain;

import com.useorigin.riskprofile.userprofile.request.UserProfileRequest;

public class AutoInsurance implements Insurance {

    private Boolean hasAuto;
    private UserProfileRequest userProfile;

    public AutoInsurance(UserProfileRequest userProfile){
        this.userProfile = userProfile;
        if (this.userProfile.getVehicle() != null) {
            this.hasAuto = true;
        }else{
            this.hasAuto = false;
        }

    }

    @Override
    public Boolean hasInsuranceVariableToBeCalculated() {
        return this.hasAuto;
    }

    @Override
    public UserProfileRequest getUserProfile() {
        return this.userProfile;
    }
}
