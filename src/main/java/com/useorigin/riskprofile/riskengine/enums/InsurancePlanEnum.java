package com.useorigin.riskprofile.riskengine.enums;

public enum InsurancePlanEnum {
    REGULAR,
    ECONOMIC,
    RESPONSIBLE,
    INELIGIBLE;

    private static final int ECONOMIC_VALUE = 0;
    private static final int MAX_REGULAR = 3;
    private static final int MIN_REGULAR = 0;
    private static final int RESPONSIBLE_RATE = 3;


    public static InsurancePlanEnum getInsurancePlanByRate(int rate){
        if (rate <= ECONOMIC_VALUE){
            return ECONOMIC;
        }
        else if (rate > MIN_REGULAR && rate < MAX_REGULAR){
            return REGULAR;
        }else if(rate >= RESPONSIBLE_RATE){
            return RESPONSIBLE;
        }
        throw new IllegalArgumentException("illegal rate calculation");
    }
}
