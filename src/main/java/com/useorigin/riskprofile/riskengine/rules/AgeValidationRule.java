package com.useorigin.riskprofile.riskengine.rules;

import com.useorigin.riskprofile.riskengine.domain.Insurance;
import com.useorigin.riskprofile.userprofile.IneligibleExepection;

public class AgeValidationRule implements  Rule{
    public static final int TWO_POINTS_TO_BE_DEDUCT = -2;
    public static final int ONE_POINTS_TO_BE_DEDUCT = -1;

    private static final Integer AGE_TO_DEDUCT_2_POINTS = 29;
    private static final Integer MAX_AGE_TO_DEDUCT_1_POINTS = 40;

    @Override
    public int calculateRule(Insurance variable) throws IneligibleExepection {
        if (variable.getUserProfile().getAge() <= AGE_TO_DEDUCT_2_POINTS){
            return TWO_POINTS_TO_BE_DEDUCT;
        }if (isAgeOnIntervalToBeDeductOnePoint(variable.getUserProfile().getAge())){
            return ONE_POINTS_TO_BE_DEDUCT;
        }
        return Rule.DEFAULT_ANSWER;
    }

    private boolean isAgeOnIntervalToBeDeductOnePoint(Integer age) {
        if (age>= Constants.MIN_AGE_TO_DEDUCT_1_POINTS && age <= MAX_AGE_TO_DEDUCT_1_POINTS){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
