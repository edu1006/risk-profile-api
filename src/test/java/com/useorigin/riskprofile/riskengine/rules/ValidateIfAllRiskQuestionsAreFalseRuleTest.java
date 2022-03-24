package com.useorigin.riskprofile.riskengine.rules;

import com.useorigin.riskprofile.riskengine.domain.AutoInsurance;
import com.useorigin.riskprofile.riskengine.domain.Insurance;
import com.useorigin.riskprofile.userprofile.IneligibleExepection;
import com.useorigin.riskprofile.userprofile.request.UserProfileRequest;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ValidateIfAllRiskQuestionsAreFalseRuleTest {

    @Test(expected =  IneligibleExepection.class)
    public void shouldThowIneligleException() throws IneligibleExepection {
        Rule r = new ValidateIfAllRiskQuestionsAreFalseRule();

        UserProfileRequest userProfile  = new UserProfileRequest() ;
        userProfile.setIncome(24.000);
        Integer[] questions = {0,0,0} ;
        userProfile.setRiskQuestions(questions);
        Insurance variable = new AutoInsurance(userProfile);
        r.calculateRule(variable);
    }

    @Test
    public void shouldGetDefaultAnswerWithIncomeLowerTargetValue() throws IneligibleExepection {
        Rule r = new ValidateIfAllRiskQuestionsAreFalseRule();

        UserProfileRequest userProfile  = new UserProfileRequest() ;
        userProfile.setIncome(24.000);
        Integer[] questions = {0,0,1} ;
        userProfile.setRiskQuestions(questions);
        Insurance variable = new AutoInsurance(userProfile);
        int rate = r.calculateRule(variable);

        assertThat(rate).isEqualTo(ValidateIfAllRiskQuestionsAreFalseRule.DEFAULT_ANSWER);
    }


    @Test(expected = IneligibleExepection.class)
    public void shouldGetDefaultAnswerWithIncomeAboveTargetValue() throws IneligibleExepection {
        Rule r = new ValidateIfAllRiskQuestionsAreFalseRule();

        UserProfileRequest userProfile  = new UserProfileRequest() ;
        userProfile.setIncome(25.001);
        Integer[] questions = {0,0,0} ;
        userProfile.setRiskQuestions(questions);
        Insurance variable = new AutoInsurance(userProfile);
        int rate = r.calculateRule(variable);

        assertThat(rate).isEqualTo(ValidateIfAllRiskQuestionsAreFalseRule.DEFAULT_ANSWER);
    }
}
