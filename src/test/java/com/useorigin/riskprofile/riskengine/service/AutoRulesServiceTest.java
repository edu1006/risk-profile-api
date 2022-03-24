package com.useorigin.riskprofile.riskengine.service;

import com.useorigin.riskprofile.riskengine.enums.InsurancePlanEnum;
import com.useorigin.riskprofile.userprofile.request.UserProfileRequest;
import com.useorigin.riskprofile.userprofile.request.Vehicle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
@RunWith( SpringJUnit4ClassRunner.class )
public class AutoRulesServiceTest {

    @Autowired
    AutoRulesService service;

    /**
     * testing this rule:
     *
     * If the user doesn’t have income, vehicles or houses, she is ineligible for disability, auto, and home insurance, respectively.
     */
    @Test
    public void shouldGetIneligibleForAuto(){
        UserProfileRequest user =  new UserProfileRequest();
        InsurancePlanEnum value = service.calculateInsurancePlan(user);
        assertThat(value).isEqualTo(InsurancePlanEnum.INELIGIBLE);
    }
    @Test
    public void shouldGetRegularForAuto()  {
        UserProfileRequest user =  new UserProfileRequest();
        user.setVehicle(new Vehicle());
        user.getVehicle().setYear(2022);
        user.setAge(45);
        user.setIncome(180000.00);
        Integer[] arrQuestions = {0,0,0};
        user.setRiskQuestions(arrQuestions );

        InsurancePlanEnum value = service.calculateInsurancePlan(user);
        assertThat(value).isEqualTo(InsurancePlanEnum.REGULAR);

    }

    @Test
    public void shouldGetResponsibleForAuto()  {
        UserProfileRequest user =  new UserProfileRequest();
        user.setVehicle(new Vehicle());
        user.getVehicle().setYear(2022);
        user.setAge(45);
        user.setIncome(180000.00);
        Integer[] arrQuestions = {1,1,1};
        user.setRiskQuestions(arrQuestions );

        InsurancePlanEnum value = service.calculateInsurancePlan(user);
        assertThat(value).isEqualTo(InsurancePlanEnum.RESPONSIBLE);

    }


    @Test
    public void shouldGetEconomicForAuto()  {
        UserProfileRequest user =  new UserProfileRequest();
        user.setVehicle(new Vehicle());
        user.getVehicle().setYear(2015);
        user.setAge(25);
        user.setIncome(220000.00);
        Integer[] arrQuestions = {0,0,0};
        user.setRiskQuestions(arrQuestions );

        InsurancePlanEnum value = service.calculateInsurancePlan(user);
        assertThat(value).isEqualTo(InsurancePlanEnum.ECONOMIC);

    }


    @Test
    public void shouldGetIneligleWithIncomeAboveTArget()  {
        UserProfileRequest user =  new UserProfileRequest();
        user.setVehicle(new Vehicle());
        user.getVehicle().setYear(2015);
        user.setAge(25);
        user.setIncome(24000.00);
        Integer[] arrQuestions = {0,0,0};
        user.setRiskQuestions(arrQuestions );

        InsurancePlanEnum value = service.calculateInsurancePlan(user);
        assertThat(value).isEqualTo(InsurancePlanEnum.INELIGIBLE);

    }

}
