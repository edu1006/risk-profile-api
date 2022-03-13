package com.useorigin.riskprofile.userprofile.service;

import com.useorigin.riskprofile.userprofile.request.UserProfileRequest;
import com.useorigin.riskprofile.userprofile.request.Vehicle;
import com.useorigin.riskprofile.userprofile.response.RiskProfileResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserProfileServiceTest {
    @Autowired
    private UserProfileService service;

    @Test(expected = IllegalArgumentException.class)
    public void shouldValidateUserProfileNull() {
       this.service.getUserRiskProfile(null);
    }

    public void shouldCalculateRiskProfile() {
        UserProfileRequest request = new UserProfileRequest();
        request.setAge(18);
        request.setVehicle(new Vehicle());
        request.getVehicle().setYear(2020);
        request.setIncome(15000.00);
        request.setMaritalStatus("single");
        request.setDependents(0);
        Integer[] arr = {0, 0, 0};
        request.setRiskQuestions(arr);
        RiskProfileResponse response = this.service.getUserRiskProfile(request);

        assertThat(response).isNotNull();
    }
}
