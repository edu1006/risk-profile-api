package com.useorigin.riskprofile.riskengine.service;


import com.useorigin.riskprofile.riskengine.enums.InsurancePlanEnum;
import com.useorigin.riskprofile.userprofile.request.UserProfileRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith( SpringJUnit4ClassRunner.class )
public class LifeServiceTest {
    @Autowired
    LifeRulesService service;

    @Test
    public void shouldGetInegibleByAge(){
        UserProfileRequest userProfile = new UserProfileRequest();
        userProfile.setAge(61);
        InsurancePlanEnum plan = service.calculateInsurancePlan(userProfile);
        assertThat(plan).isEqualTo(InsurancePlanEnum.INELIGIBLE);
    }

    @Test
    public void shouldGetEconomic(){

        UserProfileRequest user = new UserProfileRequest();
        user.setAge(20);
        user.setMaritalStatus("single");
        user.setIncome(220000.00);
        user.setDependents(0);

        Integer[] arrQuestions = {0,0,0};
        user.setRiskQuestions(arrQuestions );

        InsurancePlanEnum plan = service.calculateInsurancePlan(user);
        assertThat(plan).isEqualTo(InsurancePlanEnum.ECONOMIC);

    }


    @Test
    public void shouldGetRegular(){

        UserProfileRequest user = new UserProfileRequest();
        user.setAge(45);
        user.setIncome(180000.00);
        user.setDependents(1);
        user.setMaritalStatus("married");
        Integer[] arrQuestions = {0,0,0};
        user.setRiskQuestions(arrQuestions );


        InsurancePlanEnum plan = service.calculateInsurancePlan(user);
        assertThat(plan).isEqualTo(InsurancePlanEnum.REGULAR);

    }


    @Test
    public void shouldGetResponsible(){

        UserProfileRequest user = new UserProfileRequest();
        user.setAge(45);
        user.setIncome(180000.00);
        user.setDependents(1);
        user.setMaritalStatus("married");
        Integer[] arrQuestions = {1,1,1};
        user.setRiskQuestions(arrQuestions );


        InsurancePlanEnum plan = service.calculateInsurancePlan(user);
        assertThat(plan).isEqualTo(InsurancePlanEnum.RESPONSIBLE);

    }

}
