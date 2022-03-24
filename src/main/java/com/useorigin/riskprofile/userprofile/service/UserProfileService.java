package com.useorigin.riskprofile.userprofile.service;

import com.useorigin.riskprofile.riskengine.service.*;
import com.useorigin.riskprofile.userprofile.request.UserProfileRequest;
import com.useorigin.riskprofile.userprofile.response.RiskProfileResponse;
import com.useorigin.riskprofile.userprofile.validation.UserProfileValidator;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {

    private AutoRulesService autoRulesService;

    private HouseRulesService houseRulesService;

    private LifeRulesService lifeRulesService;

    private DisabilityRulesService disabilityRulesService;

    private UmbrellaRulesService umbrellaRulesService;

    public UserProfileService(AutoRulesService autoRulesService, HouseRulesService houseRulesService, LifeRulesService lifeRulesService, DisabilityRulesService disabilityRulesService, UmbrellaRulesService umbrellaRulesService){
        this.autoRulesService = autoRulesService;
        this.houseRulesService = houseRulesService;
        this.lifeRulesService = lifeRulesService;
        this.disabilityRulesService = disabilityRulesService;
        this.umbrellaRulesService = umbrellaRulesService;
    }

    public RiskProfileResponse getUserRiskProfile(UserProfileRequest request) {
        UserProfileValidator.validateUserProfile(request);
        RiskProfileResponse riskProfile = new RiskProfileResponse();
        riskProfile.setAuto(autoRulesService.calculateInsurancePlan(request).toString());
        riskProfile.setDisability(this.disabilityRulesService.calculateInsurancePlan(request).toString());
        riskProfile.setLife(this.lifeRulesService.calculateInsurancePlan(request).toString());
        riskProfile.setHome(this.houseRulesService.calculateInsurancePlan(request).toString());
        riskProfile.setUmbrella(this.umbrellaRulesService.calculateInsurancePlan(request, riskProfile).toString());
        return riskProfile;
    }

}
