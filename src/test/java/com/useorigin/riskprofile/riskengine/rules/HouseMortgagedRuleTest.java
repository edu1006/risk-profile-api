package com.useorigin.riskprofile.riskengine.rules;
import com.useorigin.riskprofile.riskengine.domain.HouseInsurance;
import com.useorigin.riskprofile.riskengine.domain.Insurance;
import com.useorigin.riskprofile.userprofile.IneligibleExepection;
import com.useorigin.riskprofile.userprofile.request.UserProfileRequest;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HouseMortgagedRuleTest {

    @Test
    public void shouldValidateHouseMorgagedRule() throws IneligibleExepection {

        Rule r = new HouseMortgagedRule();

        UserProfileRequest user = new UserProfileRequest();
        user.setHouse(new com.useorigin.riskprofile.userprofile.request.House());
        user.getHouse().setOwnership_status("mortgaged");
        Insurance variable = new HouseInsurance(user);

        int value = r.calculateRule(variable);

        assertThat(value).isEqualTo(Constants.HOUSE_MORTGAGED_RULE_POINTS);
    }


    @Test
    public void shouldValidateHouseOwnedRule() throws IneligibleExepection {

        Rule r = new HouseMortgagedRule();

        UserProfileRequest user = new UserProfileRequest();
        user.setHouse(new com.useorigin.riskprofile.userprofile.request.House());
        user.getHouse().setOwnership_status("owned");
        Insurance variable = new HouseInsurance(user);

        int value = r.calculateRule(variable);

        assertThat(value).isEqualTo(Rule.DEFAULT_ANSWER);
    }

}
