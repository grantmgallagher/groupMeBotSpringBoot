package com.dev.groupmemodel;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "response",
        "meta"
})
public class GroupMeMessageResponseEnvelope {

    @JsonProperty("response")
    private GroupMeMessage response;
    @JsonProperty("meta")
    private GroupMeResponseMeta meta;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("response")
    public GroupMeMessage getResponse() {
        return response;
    }

    @JsonProperty("response")
    public void setResponse(GroupMeMessage response) {
        this.response = response;
    }

    @JsonProperty("meta")
    public GroupMeResponseMeta getMeta() {
        return meta;
    }

    @JsonProperty("meta")
    public void setMeta(GroupMeResponseMeta meta) {
        this.meta = meta;
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