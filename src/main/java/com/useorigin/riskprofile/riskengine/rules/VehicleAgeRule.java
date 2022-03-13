package com.useorigin.riskprofile.riskengine.rules;

import com.useorigin.riskprofile.riskengine.domain.Insurance;
import com.useorigin.riskprofile.userprofile.IneligibleExepection;

import java.util.Calendar;

public class VehicleAgeRule implements Rule{


    @Override
    public int calculateRule(Insurance variable) throws IneligibleExepection {
        int targetYear = Calendar.getInstance().get(Calendar.YEAR) - Constants.AGE_VEHICLE_VALIDATION;
        if (variable.getUserProfile().getVehicle().getYear() >= targetYear ){
            return Constants.POINTS_VEHICLE_AGE_RULE;
        }
        return DEFAULT_ANSWER;
    }
}
