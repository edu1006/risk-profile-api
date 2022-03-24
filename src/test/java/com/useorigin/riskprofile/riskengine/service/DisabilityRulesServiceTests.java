package com.useorigin.riskprofile.riskengine.service;

import com.useorigin.riskprofile.riskengine.enums.InsurancePlanEnum;
import com.useorigin.riskprofile.userprofile.request.House;
import com.useorigin.riskprofile.userprofile.request.UserProfileRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith( SpringJUnit4ClassRunner.class )
public class DisabilityRulesServiceTests {

    @Autowired
    DisabilityRulesService service;

    @Test
    public void shouldGetInegibility(){
        UserProfileRequest userProfile = new UserProfileRequest();

        userProfile.setAge(61);
        userProfile.setIncome(200000.00);
        userProfile.setMaritalStatus("married");
        userProfile.setDependents(0);
        userProfile.setHouse(new House());
        userProfile.getHouse().setOwnership_status("owned");

        InsurancePlanEnum plan = service.calculateInsurancePlan(userProfile);
        assertThat(plan).isEqualTo(InsurancePlanEnum.INELIGIBLE);

    }



    @Test
    public void shouldGetEconomic(){

        UserProfileRequest userProfile = new UserProfileRequest();

        userProfile.setAge(58);
        userProfile.setIncome(200000.00);
        userProfile.setMaritalStatus("married");
        userProfile.setDependents(0);
        userProfile.setHouse(new House());
        userProfile.getHouse().setOwnership_status("owned");
        Integer[] arrQuestions = {0,0,0};
        userProfile.setRiskQuestions(arrQuestions );

        InsurancePlanEnum plan = service.calculateInsurancePlan(userProfile);
        assertThat(plan).isEqualTo(InsurancePlanEnum.ECONOMIC);
    }

    @Test
    public void shouldGetRegular(){

        UserProfileRequest userProfile = new UserProfileRequest();

        userProfile.setAge(45);
        userProfile.setIncome(190000.00);
        userProfile.setMaritalStatus("single");
        userProfile.setDependents(2);
        userProfile.setHouse(new House());
        userProfile.getHouse().setOwnership_status("owned");
        Integer[] arrQuestions = {0,0,0};
        userProfile.setRiskQuestions(arrQuestions );

        InsurancePlanEnum plan = service.calculateInsurancePlan(userProfile);
        assertThat(plan).isEqualTo(InsurancePlanEnum.REGULAR);
    }


    @Test
    public void shouldGetResponsible(){

        UserProfileRequest userProfile = new UserProfileRequest();

        userProfile.setAge(45);
        userProfile.setIncome(190000.00);
        userProfile.setMaritalStatus("single");
        userProfile.setDependents(2);
        userProfile.setHouse(new House());
        userProfile.getHouse().setOwnership_status("owned");
        Integer[] arrQuestions = {1,1,0};
        userProfile.setRiskQuestions(arrQuestions );

        InsurancePlanEnum plan = service.calculateInsurancePlan(userProfile);
        assertThat(plan).isEqualTo(InsurancePlanEnum.RESPONSIBLE);
    }

    @Test
    public void shouldGetInegibleWithInvalidIncome(){

        UserProfileRequest userProfile = new UserProfileRequest();

        userProfile.setAge(58);
        userProfile.setIncome(0.0);
        userProfile.setMaritalStatus("married");
        userProfile.setDependents(0);
        userProfile.setHouse(new House());
        userProfile.getHouse().setOwnership_status("owned");
        Integer[] arrQuestions = {0,0,0};
        userProfile.setRiskQuestions(arrQuestions );

        InsurancePlanEnum plan = service.calculateInsurancePlan(userProfile);
        assertThat(plan).isEqualTo(InsurancePlanEnum.INELIGIBLE);
    }




    @Test
    public void shouldTestNewRuleAddingPointsOnDisability(){

        UserProfileRequest userProfile = new UserProfileRequest();

        userProfile.setAge(58);
        userProfile.setIncome(200000.00);
        userProfile.setMaritalStatus("married");
        userProfile.setDependents(0);
        userProfile.setHouse(new House());
        userProfile.getHouse().setOwnership_status("owned");
        Integer[] arrQuestions = {0,1,0};
        userProfile.setRiskQuestions(arrQuestions );

        InsurancePlanEnum plan = service.calculateInsurancePlan(userProfile);
        assertThat(plan).isEqualTo(InsurancePlanEnum.REGULAR);
    }

}
