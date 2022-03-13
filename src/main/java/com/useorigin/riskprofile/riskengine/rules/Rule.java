package com.useorigin.riskprofile.riskengine.rules;

import com.useorigin.riskprofile.riskengine.domain.Insurance;
import com.useorigin.riskprofile.userprofile.IneligibleExepection;

public interface Rule {
    int DEFAULT_ANSWER = 0;
    public int calculateRule(Insurance variable) throws IneligibleExepection;
}
