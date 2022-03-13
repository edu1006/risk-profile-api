package com.useorigin.riskprofile.riskengine.domain;

import com.useorigin.riskprofile.userprofile.request.UserProfileRequest;

public class HouseInsurance implements Insurance {

    private Boolean hasHouse;
    private UserProfileRequest userProfile;

    public HouseInsurance(UserProfileRequest userProfile){
        this.userProfile = userProfile;
        if (this.userProfile.getHouse() != null) {
            this.hasHouse = true;
        }else{
            this.hasHouse = false;
        }

    }

    @Override
    public Boolean hasInsuranceVariableToBeCalculated() {
        return this.hasHouse;
    }

    @Override
    public UserProfileRequest getUserProfile() {
        return this.userProfile;
    }
}
