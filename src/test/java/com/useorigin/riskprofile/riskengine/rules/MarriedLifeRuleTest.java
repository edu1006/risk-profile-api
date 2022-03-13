package com.useorigin.riskprofile.riskengine.rules;
import com.useorigin.riskprofile.riskengine.domain.Insurance;
import com.useorigin.riskprofile.riskengine.domain.LifeInsurance;
import com.useorigin.riskprofile.userprofile.IneligibleExepection;
import com.useorigin.riskprofile.userprofile.request.UserProfileRequest;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class MarriedLifeRuleTest {
    @Test
    public void shouldValidateWhenUserIsMarried() throws IneligibleExepection {
        Rule r = new MarriedLifeRule();

        UserProfileRequest user = new UserProfileRequest();
        user.setMaritalStatus("married");
        Insurance variable = new LifeInsurance(user);

        int value = r.calculateRule(variable);

        assertThat(value).isEqualTo(Constants.MARRIED_LIFE_RULE_POINT);

    }


    @Test
    public void shouldValidateWhenUserIsSingle() throws IneligibleExepection {
        Rule r = new MarriedLifeRule();

        UserProfileRequest user = new UserProfileRequest();
        user.setMaritalStatus("single");
        Insurance variable = new LifeInsurance(user);

        int value = r.calculateRule(variable);

        assertThat(value).isEqualTo(Rule.DEFAULT_ANSWER);

    }

}
