package com.useorigin.riskprofile.riskengine.rules;

import com.useorigin.riskprofile.riskengine.domain.IUmbrellaInsurance;
import com.useorigin.riskprofile.riskengine.domain.Insurance;
import com.useorigin.riskprofile.riskengine.domain.UmbrellaInsurance;
import com.useorigin.riskprofile.riskengine.enums.InsurancePlanEnum;
import com.useorigin.riskprofile.userprofile.IneligibleExepection;
import com.useorigin.riskprofile.userprofile.request.UserProfileRequest;
import com.useorigin.riskprofile.userprofile.response.RiskProfileResponse;
import org.apache.catalina.User;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ValidateIsImbrellaServiceIsAbleTest {

    @Test
    public void shouldGetUmblella() throws IneligibleExepection {
        Rule r = new ValidateIsImbrellaServiceIsAble();

        RiskProfileResponse userResponse = new RiskProfileResponse();
        userResponse.setAuto(InsurancePlanEnum.ECONOMIC.toString());
        userResponse.setLife(InsurancePlanEnum.INELIGIBLE.toString());
        userResponse.setHome(InsurancePlanEnum.INELIGIBLE.toString());
        userResponse.setDisability(InsurancePlanEnum.INELIGIBLE.toString());

        UserProfileRequest userProfile = new UserProfileRequest();
        IUmbrellaInsurance variable = new UmbrellaInsurance(userProfile, userResponse);
        int rate = r.calculateRule(variable);

        assertThat(rate).isEqualTo(ValidateIsImbrellaServiceIsAble.DEFAULT_ANSWER);
    }


    @Test(expected = IneligibleExepection.class)
    public void shouldGetInelibleException() throws IneligibleExepection {
        Rule r = new ValidateIsImbrellaServiceIsAble();

        RiskProfileResponse userResponse = new RiskProfileResponse();
        userResponse.setAuto(InsurancePlanEnum.INELIGIBLE.toString());
        userResponse.setLife(InsurancePlanEnum.INELIGIBLE.toString());
        userResponse.setHome(InsurancePlanEnum.INELIGIBLE.toString());
        userResponse.setDisability(InsurancePlanEnum.INELIGIBLE.toString());

        UserProfileRequest userProfile = new UserProfileRequest();
        IUmbrellaInsurance variable = new UmbrellaInsurance(userProfile, userResponse);
        int rate = r.calculateRule(variable);

        assertThat(rate).isEqualTo(ValidateIsImbrellaServiceIsAble.DEFAULT_ANSWER);
    }
}
