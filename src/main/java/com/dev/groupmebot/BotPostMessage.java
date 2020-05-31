package com.dev.groupmebot;

import com.dev.groupmemodel.GroupMeAttachment;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BotPostMessage {
    @JsonProperty("bot_id")
    private String botId;
    @JsonProperty("text")
    private String text;
    @JsonProperty("picture_url")
    private String pictureURL;
    @JsonProperty("attachments")
    private List<GroupMeAttachment> attachments = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getBotId() {
        return botId;
    }

    public void setBotId(String botId)
    {
        this.botId = botId;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public String getPictureURL()
    {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL)
    {
        this.pictureURL = pictureURL;
    }

    @JsonProperty("attachments")
    public List<GroupMeAttachment> getAttachments() {
        return attachments;
    }

    @JsonProperty("attachments")
    public void setAttachments(List<GroupMeAttachment> attachments) {
        this.attachments = attachments;
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
