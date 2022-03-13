package com.useorigin.riskprofile.riskengine.rules;

import com.useorigin.riskprofile.riskengine.domain.AutoInsurance;
import com.useorigin.riskprofile.riskengine.domain.Insurance;
import com.useorigin.riskprofile.userprofile.IneligibleExepection;
import com.useorigin.riskprofile.userprofile.request.UserProfileRequest;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IncomeAboveTargetValueTest {
    @Test
    public void shouldValidateIncomeUnderTargetValue() throws IneligibleExepection {
        Rule r = new IncomeAboveTargetValueRule();
        UserProfileRequest profile= new UserProfileRequest();
        profile.setIncome(199000.00);
        Insurance variable = new AutoInsurance(profile);
        int value = r.calculateRule(variable);
        assertThat(value).isEqualTo(Rule.DEFAULT_ANSWER);
    }

    @Test
    public void shouldValidateIncomeAboveTargetValue() throws IneligibleExepection {
        Rule r = new IncomeAboveTargetValueRule();
        UserProfileRequest profile= new UserProfileRequest();
        profile.setIncome(210000.00);
        Insurance variable = new AutoInsurance(profile);
        int value = r.calculateRule(variable);
        assertThat(value).isEqualTo(Constants.POINT_INCOME_VALIDATION_DEDUCT);
    }

}
