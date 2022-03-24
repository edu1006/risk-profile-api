package com.useorigin.riskprofile.userprofile.response;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data

@NoArgsConstructor
public class RiskProfileResponse {

    private String auto;
    private String disability;
    private String home;
    private String life;
    private String umbrella;
}
