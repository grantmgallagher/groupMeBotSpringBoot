package com.dev.groupmebot;


import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "compliment"
})
public class Compliment {

    @JsonProperty("compliment")
    private String compliment;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("compliment")
    public String getCompliment() {
        return compliment;
    }

    @JsonProperty("compliment")
    public void setCompliment(String compliment) {
        this.compliment = compliment;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
