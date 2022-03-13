package com.useorigin.riskprofile.userprofile.validation;

import com.useorigin.riskprofile.userprofile.enums.MaritalStatusEnum;
import com.useorigin.riskprofile.userprofile.request.UserProfileRequest;

public final class UserProfileValidator {
    private UserProfileValidator() {
        throw new IllegalCallerException("utility class");
    }

    public static void validateUserProfile(UserProfileRequest userProfile) {
        if (userProfile == null) {
            throw new IllegalArgumentException("user can not be null");
        }
        if (userProfile.getRiskQuestions() == null) {
            throw new IllegalArgumentException("risk question can not be null");
        }

        if (userProfile.getDependents() == null || userProfile.getDependents() < 0){
            throw new IllegalArgumentException("invalid dependents");

        }
        if (userProfile.getAge() == null ||  userProfile.getAge() < 0) {
            throw new IllegalArgumentException("invalid age");
        }
        if (userProfile.getVehicle() != null && userProfile.getVehicle().getYear() == null) {
            throw new IllegalArgumentException("vehicle year can not be null");

        }

        if (userProfile.getIncome() == null ||  userProfile.getIncome() < 0) {
            throw new IllegalArgumentException("Income should be bigger than 0");
        }

        //if not find, should thrwo EnumConstantNotPresentException
        MaritalStatusEnum.valueOf(userProfile.getMaritalStatus().toUpperCase());

    }
}
