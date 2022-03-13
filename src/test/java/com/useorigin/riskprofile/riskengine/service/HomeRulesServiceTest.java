package com.useorigin.riskprofile.riskengine.service;

import com.useorigin.riskprofile.riskengine.enums.InsurancePlanEnum;
import com.useorigin.riskprofile.userprofile.request.House;
import com.useorigin.riskprofile.userprofile.request.UserProfileRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@RunWith( SpringJUnit4ClassRunner.class )

public class HomeRulesServiceTest {

    @Autowired
    HouseRulesService houseService;

    @Test
    public void shouldGetInegible() {
        UserProfileRequest userProfile = new UserProfileRequest();
        InsurancePlanEnum plan = houseService.calculateInsurancePlan(userProfile);
        assertThat(plan).isEqualTo(InsurancePlanEnum.INELIGIBLE);
    }


    @Test
    public void shouldGetEconomic() {
        UserProfileRequest userProfile = new UserProfileRequest();
        userProfile.setHouse(new House());
        userProfile.setIncome(180000.00);
        userProfile.setAge(35);
        Integer[] arrQuestions = {0,0,0};
        userProfile.setRiskQuestions(arrQuestions );
        userProfile.getHouse().setOwnership_status("owned");
        InsurancePlanEnum plan = houseService.calculateInsurancePlan(userProfile);
        assertThat(plan).isEqualTo(InsurancePlanEnum.ECONOMIC);

    }



    @Test
    public void shouldGetRegularPlan() {
        UserProfileRequest userProfile = new UserProfileRequest();
        userProfile.setHouse(new House());
        userProfile.setIncome(180000.00);
        userProfile.setAge(45);
        Integer[] arrQuestions = {0,0,0};
        userProfile.setRiskQuestions(arrQuestions );

        userProfile.getHouse().setOwnership_status("mortgaged");
        InsurancePlanEnum plan = houseService.calculateInsurancePlan(userProfile);
        assertThat(plan).isEqualTo(InsurancePlanEnum.REGULAR);
    }


    @Test
    public void shouldGetResponsbilePlan() {
        UserProfileRequest userProfile = new UserProfileRequest();
        userProfile.setHouse(new House());
        userProfile.setIncome(180000.00);
        userProfile.setAge(45);
        Integer[] arrQuestions = {1,1,1};
        userProfile.setRiskQuestions(arrQuestions );

        userProfile.getHouse().setOwnership_status("mortgaged");
        InsurancePlanEnum plan = houseService.calculateInsurancePlan(userProfile);
        assertThat(plan).isEqualTo(InsurancePlanEnum.RESPONSIBLE);
    }

}

