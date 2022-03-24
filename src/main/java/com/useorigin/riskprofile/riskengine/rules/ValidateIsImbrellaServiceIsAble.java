package com.useorigin.riskprofile.riskengine.rules;

import com.useorigin.riskprofile.riskengine.domain.IUmbrellaInsurance;
import com.useorigin.riskprofile.riskengine.domain.Insurance;
import com.useorigin.riskprofile.riskengine.enums.InsurancePlanEnum;
import com.useorigin.riskprofile.userprofile.IneligibleExepection;
import com.useorigin.riskprofile.userprofile.response.RiskProfileResponse;

public class ValidateIsImbrellaServiceIsAble implements  Rule{
    @Override
    public int calculateRule(Insurance variable) throws IneligibleExepection {
        if (variable instanceof IUmbrellaInsurance) {
            IUmbrellaInsurance umbrellaInsurance = (IUmbrellaInsurance) variable;
            if (validateIfHasEconomicOutput(umbrellaInsurance.getRiskProfileResponse())){
                return DEFAULT_ANSWER;
            }
        }

        throw  new IneligibleExepection();
    }

    private boolean validateIfHasEconomicOutput(RiskProfileResponse riskProfileResponse) {
        if(riskProfileResponse.getAuto().equals(InsurancePlanEnum.ECONOMIC.toString()) ||
        riskProfileResponse.getDisability().equals(InsurancePlanEnum.ECONOMIC.toString()) ||
        riskProfileResponse.getHome().equals(InsurancePlanEnum.ECONOMIC.toString()) ||
        riskProfileResponse.getLife().equals(InsurancePlanEnum.ECONOMIC.toString())) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
