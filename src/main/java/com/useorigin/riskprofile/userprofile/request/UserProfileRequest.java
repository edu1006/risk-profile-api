package com.useorigin.riskprofile.userprofile.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data

@NoArgsConstructor
public class
UserProfileRequest{


    private Integer age;
    private Integer dependents;
    private House house;
    private Double income;
    @JsonProperty("marital_status")
    private String maritalStatus;
    private Vehicle vehicle;
    @JsonProperty("risk_questions")
    private Integer[] riskQuestions;

}
