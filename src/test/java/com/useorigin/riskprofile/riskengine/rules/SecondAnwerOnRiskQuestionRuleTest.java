package com.useorigin.riskprofile.riskengine.rules;

import com.useorigin.riskprofile.riskengine.domain.DisabilityInsurance;
import com.useorigin.riskprofile.riskengine.domain.Insurance;
import com.useorigin.riskprofile.userprofile.IneligibleExepection;
import com.useorigin.riskprofile.userprofile.request.UserProfileRequest;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SecondAnwerOnRiskQuestionRuleTest {



    @Test
    public void shouldAddTwoPointOnDisabilityINsurance() throws IneligibleExepection {
        Rule rule = new SecondAnwerOnRiskQuestionRule();
        UserProfileRequest userProfile = new UserProfileRequest();
        Integer[] quetions = {0,1,0} ;
        userProfile.setRiskQuestions(quetions);
        Insurance variable = new DisabilityInsurance(userProfile);
        int answer = rule.calculateRule(variable);
        assertThat(answer).isEqualTo(Constants.VALUE_TO_BE_ADD_ON_RISK_ANWER_RULE);

    }

    @Test
    public void shouldGetDefaultAnwer() throws IneligibleExepection {
        Rule rule = new SecondAnwerOnRiskQuestionRule();
        UserProfileRequest userProfile = new UserProfileRequest();
        Integer[] quetions = {0,0,0} ;
        userProfile.setRiskQuestions(quetions);
        Insurance variable = new DisabilityInsurance(userProfile);
        int answer = rule.calculateRule(variable);
        assertThat(answer).isEqualTo(SecondAnwerOnRiskQuestionRule.DEFAULT_ANSWER);

    }
}
