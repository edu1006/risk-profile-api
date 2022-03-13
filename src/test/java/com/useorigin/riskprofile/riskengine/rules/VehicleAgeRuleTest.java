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
public class VehicleAgeRuleTest {

    @Test
    public void shouldValidateVehicleAgeUpToTargetYear() throws IneligibleExepection {
        Rule r = new VehicleAgeRule();

        UserProfileRequest profile =  new UserProfileRequest();
        profile.setVehicle(new Vehicle());
        profile.getVehicle().setYear(2020);
        Insurance variable = new AutoInsurance(profile);

        int value = r.calculateRule(variable);

        assertThat(value).isEqualTo(Constants.POINTS_VEHICLE_AGE_RULE);
    }


    @Test
    public void shouldValidateVehicleAgeUnderToTargetYear() throws IneligibleExepection {
        Rule r = new VehicleAgeRule();

        UserProfileRequest profile =  new UserProfileRequest();
        profile.setVehicle(new Vehicle());
        profile.getVehicle().setYear(2016);
        Insurance variable = new AutoInsurance(profile);

        int value = r.calculateRule(variable);

        assertThat(value).isEqualTo(Rule.DEFAULT_ANSWER);
    }
}

