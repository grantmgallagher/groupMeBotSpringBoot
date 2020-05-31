package com.dev.groupmebot;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "number",
        "language",
        "insult",
        "created",
        "shown",
        "createdby",
        "active",
        "comment"
})
public class Insult {

    @JsonProperty("number")
    private String number;
    @JsonProperty("language")
    private String language;
    @JsonProperty("insult")
    private String insult;
    @JsonProperty("created")
    private String created;
    @JsonProperty("shown")
    private String shown;
    @JsonProperty("createdby")
    private String createdby;
    @JsonProperty("active")
    private String active;
    @JsonProperty("comment")
    private String comment;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("number")
    public String getNumber() {
        return number;
    }

    @JsonProperty("number")
    public void setNumber(String number) {
        this.number = number;
    }

    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
    }

    @JsonProperty("insult")
    public String getInsult() {
        return insult;
    }

    @JsonProperty("insult")
    public void setInsult(String insult) {
        this.insult = insult;
    }

    @JsonProperty("created")
    public String getCreated() {
        return created;
    }

    @JsonProperty("created")
    public void setCreated(String created) {
        this.created = created;
    }

    @JsonProperty("shown")
    public String getShown() {
        return shown;
    }

    @JsonProperty("shown")
    public void setShown(String shown) {
        this.shown = shown;
    }

    @JsonProperty("createdby")
    public String getCreatedby() {
        return createdby;
    }

    @JsonProperty("createdby")
    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    @JsonProperty("active")
    public String getActive() {
        return active;
    }

    @JsonProperty("active")
    public void setActive(String active) {
        this.active = active;
    }

    @JsonProperty("comment")
    public String getComment() {
        return comment;
    }

    @JsonProperty("comment")
    public void setComment(String comment) {
        this.comment = comment;
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