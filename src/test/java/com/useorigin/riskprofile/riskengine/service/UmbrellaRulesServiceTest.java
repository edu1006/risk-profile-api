package com.useorigin.riskprofile.riskengine.service;

import com.useorigin.riskprofile.riskengine.enums.InsurancePlanEnum;
import com.useorigin.riskprofile.userprofile.IneligibleExepection;
import com.useorigin.riskprofile.userprofile.request.UserProfileRequest;
import com.useorigin.riskprofile.userprofile.request.Vehicle;
import com.useorigin.riskprofile.userprofile.response.RiskProfileResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith( SpringJUnit4ClassRunner.class )
public class UmbrellaRulesServiceTest {

    @Autowired
    UmbrellaRulesService service;

    @Test
    public void shouldGetUmbrellaEconomic() {

        UserProfileRequest user = new UserProfileRequest();
        user.setVehicle(new Vehicle());
        user.getVehicle().setYear(2015);
        user.setAge(25);
        user.setIncome(220000.00);
        Integer[] arrQuestions = {1,0,0};
        user.setRiskQuestions(arrQuestions );
        RiskProfileResponse userResponse = new RiskProfileResponse();

        userResponse.setDisability(InsurancePlanEnum.ECONOMIC.toString());
        userResponse.setHome(InsurancePlanEnum.ECONOMIC.toString());
        userResponse.setAuto(InsurancePlanEnum.ECONOMIC.toString());
        userResponse.setLife(InsurancePlanEnum.ECONOMIC.toString());

        InsurancePlanEnum plan = service.calculateInsurancePlan(user, userResponse);

        assertThat(plan).isEqualTo(InsurancePlanEnum.ECONOMIC);
    }


    @Test
    public void shouldGetIneligibleByRiskQuestions() {

        UserProfileRequest user = new UserProfileRequest();
        user.setVehicle(new Vehicle());
        user.getVehicle().setYear(2015);
        user.setAge(25);
        user.setIncome(24000.00);
        Integer[] arrQuestions = {0,0,0};
        user.setRiskQuestions(arrQuestions );
        RiskProfileResponse userResponse = new RiskProfileResponse();

        userResponse.setDisability(InsurancePlanEnum.ECONOMIC.toString());
        userResponse.setHome(InsurancePlanEnum.ECONOMIC.toString());
        userResponse.setAuto(InsurancePlanEnum.ECONOMIC.toString());
        userResponse.setLife(InsurancePlanEnum.ECONOMIC.toString());

        InsurancePlanEnum plan = service.calculateInsurancePlan(user, userResponse);

        assertThat(plan).isEqualTo(InsurancePlanEnum.INELIGIBLE);
    }


    @Test
    public void shouldGetIneligibleByRiskProfileResponse() {

        UserProfileRequest user = new UserProfileRequest();
        user.setVehicle(new Vehicle());
        user.getVehicle().setYear(2015);
        user.setAge(25);
        user.setIncome(24000.00);
        Integer[] arrQuestions = {0,0,0};
        user.setRiskQuestions(arrQuestions );
        RiskProfileResponse userResponse = new RiskProfileResponse();

        userResponse.setDisability(InsurancePlanEnum.REGULAR.toString());
        userResponse.setHome(InsurancePlanEnum.REGULAR.toString());
        userResponse.setAuto(InsurancePlanEnum.REGULAR.toString());
        userResponse.setLife(InsurancePlanEnum.REGULAR.toString());

        InsurancePlanEnum plan = service.calculateInsurancePlan(user, userResponse);

        assertThat(plan).isEqualTo(InsurancePlanEnum.INELIGIBLE);
    }


}


