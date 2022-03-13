package com.useorigin.riskprofile.riskengine.rules;

import com.useorigin.riskprofile.riskengine.domain.Insurance;
import com.useorigin.riskprofile.riskengine.domain.LifeInsurance;
import com.useorigin.riskprofile.userprofile.IneligibleExepection;
import com.useorigin.riskprofile.userprofile.request.UserProfileRequest;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserDependentsRuleTest {


    @Test
    public void shouldValidateNoOneDependends() throws IneligibleExepection {
        Rule r = new UserDependentsRule();

        UserProfileRequest user = new UserProfileRequest();
        user.setDependents(0);
        Insurance profile = new LifeInsurance(user);
        int value = r.calculateRule(profile);
        assertThat(value).isEqualTo(Rule.DEFAULT_ANSWER);
    }

    @Test
    public void shouldValidateMoreThanOneDependends() throws IneligibleExepection {
        Rule r = new UserDependentsRule();

        UserProfileRequest user = new UserProfileRequest();
        user.setDependents(1);
        Insurance profile = new LifeInsurance(user);
        int value = r.calculateRule(profile);
        assertThat(value).isEqualTo(Constants.USER_DEPENDENTS_RULE_POINTS);
    }

}
