package com.useorigin.riskprofile.userprofile.controller;

import com.useorigin.riskprofile.riskengine.enums.InsurancePlanEnum;
import com.useorigin.riskprofile.userprofile.request.UserProfileRequest;
import com.useorigin.riskprofile.userprofile.request.Vehicle;
import com.useorigin.riskprofile.userprofile.response.ErrorHandleMessageResponse;
import com.useorigin.riskprofile.userprofile.response.RiskProfileResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;


import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserProfileControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private RestTemplateBuilder builder;

    static final String PATH_RISK = "/user-profile";

    @Test
    public void shouldPostUser() throws Exception {
        UserProfileRequest request = new UserProfileRequest();
        request.setAge(18);
        request.setVehicle(new Vehicle());
        request.getVehicle().setYear(2020);
        request.setIncome(15000.00);
        request.setMaritalStatus("single");
        request.setDependents(0);
        Integer[] arr = {0, 0, 0};
        request.setRiskQuestions(arr);
        HttpEntity<?> rquestEntity = new HttpEntity<>(request);


        RiskProfileResponse response = restTemplate.postForObject(PATH_RISK, request, RiskProfileResponse.class);

        assertThat(response.getAuto()).isEqualTo(InsurancePlanEnum.ECONOMIC.toString());
    }




    @Test
    public void shouldGetBadRequestWithInvalidAge() throws Exception {
        UserProfileRequest request = new UserProfileRequest();
        request.setAge(-1);
        request.setIncome(15000.00);
        request.setMaritalStatus("single");
        request.setDependents(0);
        Integer[] arr = {0, 0, 0};
        request.setRiskQuestions(arr);
        HttpEntity<?> rquestEntity = new HttpEntity<>(request);

        ErrorHandleMessageResponse response = restTemplate.postForObject(PATH_RISK, request, ErrorHandleMessageResponse.class);
        assertThat(response.getCode()).isEqualTo(HttpStatus.BAD_REQUEST.value());
        assertThat(response.getMessage()).isEqualTo("invalid age");


    }



    @Test
    public void shouldGetBadRequestWithInvalidIncome() throws Exception {
        UserProfileRequest request = new UserProfileRequest();
        request.setAge(18);
        request.setIncome(null);
        request.setMaritalStatus("single");
        request.setDependents(0);
        Integer[] arr = {0, 0, 0};
        request.setRiskQuestions(arr);
        HttpEntity<?> rquestEntity = new HttpEntity<>(request);

        ErrorHandleMessageResponse response = restTemplate.postForObject(PATH_RISK, request, ErrorHandleMessageResponse.class);
        assertThat(response.getCode()).isEqualTo(HttpStatus.BAD_REQUEST.value());
        assertThat(response.getMessage()).isEqualTo("Income should be bigger than 0");


    }


    @Test
    public void shouldGetBadRequestWithInvalidDepends() throws Exception {
        UserProfileRequest request = new UserProfileRequest();
        request.setAge(18);
        request.setIncome(555555.00);
        request.setMaritalStatus("single");
        request.setDependents(null);
        Integer[] arr = {0, 0, 0};
        request.setRiskQuestions(arr);
        HttpEntity<?> rquestEntity = new HttpEntity<>(request);

        ErrorHandleMessageResponse response = restTemplate.postForObject(PATH_RISK, request, ErrorHandleMessageResponse.class);
        assertThat(response.getCode()).isEqualTo(HttpStatus.BAD_REQUEST.value());
        assertThat(response.getMessage()).isEqualTo("invalid dependents");


    }



    @Test
    public void shouldGetBadRequestWithInvalidMaritalStatus() throws Exception {
        UserProfileRequest request = new UserProfileRequest();
        request.setAge(18);
        request.setIncome(5555.00);
        request.setMaritalStatus("invalid");
        request.setDependents(0);
        Integer[] arr = {0, 0, 0};
        request.setRiskQuestions(arr);
        HttpEntity<?> rquestEntity = new HttpEntity<>(request);

        ErrorHandleMessageResponse response = restTemplate.postForObject(PATH_RISK, request, ErrorHandleMessageResponse.class);
        assertThat(response.getCode()).isEqualTo(HttpStatus.BAD_REQUEST.value());
        assertThat(response.getMessage()).isEqualTo("No enum constant com.useorigin.riskprofile.userprofile.enums.MaritalStatusEnum.INVALID");

    }


}


