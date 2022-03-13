package com.useorigin.riskprofile.userprofile.enums;

import java.util.Arrays;
import java.util.Optional;

public enum MaritalStatusEnum {

    SINGLE("single"),
    MARRIED("married");

    public String getValue() {
        return value;
    }

    private MaritalStatusEnum(String value) {
        this.value = value;
    }
    private String value;


}
