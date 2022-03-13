package com.useorigin.riskprofile.riskengine.rules;

import com.useorigin.riskprofile.riskengine.domain.Insurance;
import com.useorigin.riskprofile.riskengine.domain.LifeInsurance;
import com.useorigin.riskprofile.userprofile.IneligibleExepection;
import com.useorigin.riskprofile.userprofile.request.UserProfileRequest;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AgeValidationAboveTargetValueRuleTest {
    @Test(expected = IneligibleExepection.class)
    public void shouldValidateUserAboveTargetValue() throws IneligibleExepection {
        Rule r = new AgeValidationAboveTargetValueRule();
        UserProfileRequest user = new UserProfileRequest();
        user.setAge(61);
        Insurance variable =  new LifeInsurance(user);
        r.calculateRule(variable);
    }



    @Test
    public void shouldGetDefaultAnswerOnAgeValidation() throws IneligibleExepection {
        Rule r = new AgeValidationAboveTargetValueRule();
        UserProfileRequest user = new UserProfileRequest();
        user.setAge(59);
        Insurance variable =  new LifeInsurance(user);
        int value = r.calculateRule(variable);
        assertThat(value).isEqualTo(Rule.DEFAULT_ANSWER);
    }
}
