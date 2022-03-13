package com.useorigin.riskprofile.userprofile.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
@Data
@Getter
@Setter
public class House{
    private String ownership_status;
}

