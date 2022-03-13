package com.useorigin.riskprofile.riskengine.rules;
import com.useorigin.riskprofile.riskengine.domain.AutoInsurance;
import com.useorigin.riskprofile.riskengine.domain.Insurance;
import com.useorigin.riskprofile.userprofile.IneligibleExepection;
import com.useorigin.riskprofile.userprofile.request.UserProfileRequest;
import com.useorigin.riskprofile.userprofile.request.Vehicle;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IneligibleRuleTest {

    @Test(expected = IneligibleExepection.class)
    public void shouldExpectedIneligibleException() throws IneligibleExepection {
        Rule rule = new IneligibleRule();
        Insurance variable  = new AutoInsurance(new UserProfileRequest());
        rule.calculateRule(variable);
    }

    @Test
    public void shouldExecuteWithSucess() throws IneligibleExepection {
        Rule rule = new IneligibleRule();
        UserProfileRequest user = new UserProfileRequest();
        user.setVehicle(new Vehicle());
        Insurance variable  = new AutoInsurance(user);
        int value = rule.calculateRule(variable);
        assertThat(value).isEqualTo(rule.DEFAULT_ANSWER);
    }



}
