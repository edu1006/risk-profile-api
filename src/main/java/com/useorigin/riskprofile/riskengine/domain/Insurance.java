package com.useorigin.riskprofile.riskengine.domain;

import com.useorigin.riskprofile.userprofile.request.UserProfileRequest;

public interface Insurance {
    public Boolean hasInsuranceVariableToBeCalculated();
    public UserProfileRequest getUserProfile();
}
