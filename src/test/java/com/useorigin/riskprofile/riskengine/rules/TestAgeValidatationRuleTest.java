package com.useorigin.riskprofile.riskengine.rules;

import com.useorigin.riskprofile.riskengine.domain.AutoInsurance;
import com.useorigin.riskprofile.riskengine.domain.Insurance;
import com.useorigin.riskprofile.userprofile.IneligibleExepection;
import com.useorigin.riskprofile.userprofile.request.UserProfileRequest;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestAgeValidatationRuleTest {

    /**
     * If the user is under 30 years old, deduct 2 risk points from all lines of insurance.
     *
     */
    @Test
    public void shouldCalcuteUserUnder30Years() throws IneligibleExepection {
      Rule r = new AgeValidationRule();
        UserProfileRequest userRequest  = new UserProfileRequest() ;
        userRequest.setAge(29);
        Insurance variable  = new AutoInsurance(userRequest);
        int value = r.calculateRule(variable);
        assertThat(value).isEqualTo( AgeValidationRule.TWO_POINTS_TO_BE_DEDUCT);
    }


    @Test
    public void shouldCalcuteBetween30To40YearsOld() throws IneligibleExepection {
        Rule r = new AgeValidationRule();
        UserProfileRequest userRequest  = new UserProfileRequest() ;
        userRequest.setAge(31);
        Insurance variable  = new AutoInsurance(userRequest);
        int value = r.calculateRule(variable);
        assertThat(value).isEqualTo( AgeValidationRule.ONE_POINTS_TO_BE_DEDUCT);
    }

    @Test
    public void shouldGetDefaultAnswer() throws IneligibleExepection {
        Rule r = new AgeValidationRule();
        UserProfileRequest userRequest  = new UserProfileRequest() ;
        userRequest.setAge(41);
        Insurance variable  = new AutoInsurance(userRequest);
        int value = r.calculateRule(variable);
        assertThat(value).isEqualTo(AgeValidationRule.DEFAULT_ANSWER);
    }

}
