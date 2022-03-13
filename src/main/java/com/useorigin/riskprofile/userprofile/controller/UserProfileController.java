package com.useorigin.riskprofile.userprofile.controller;

import com.useorigin.riskprofile.userprofile.request.UserProfileRequest;
import com.useorigin.riskprofile.userprofile.response.RiskProfileResponse;
import com.useorigin.riskprofile.userprofile.service.UserProfileService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "user-profile")
@Log4j2
public class UserProfileController {

    @Autowired
    UserProfileService service;

    @PostMapping(produces = { "application/json" }, consumes =  { "application/json" })
    public ResponseEntity<RiskProfileResponse> calculateRiskProfile(@RequestBody UserProfileRequest request) {
        RiskProfileResponse response = service.getUserRiskProfile(request);
        log.info(response.toString());

        return ResponseEntity. ok(response);
    }

}
