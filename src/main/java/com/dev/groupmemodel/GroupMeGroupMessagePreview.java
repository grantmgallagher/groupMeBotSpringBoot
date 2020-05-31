package com.dev.groupmemodel;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "count",
        "last_message_id",
        "last_message_created_at",
        "preview"
})
public class GroupMeGroupMessagePreview {

    @JsonProperty("count")
    private Integer count;
    @JsonProperty("last_message_id")
    private String lastMessageId;
    @JsonProperty("last_message_created_at")
    private Integer lastMessageCreatedAt;
    @JsonProperty("preview")
    private GroupMeMessage preview;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("count")
    public Integer getCount() {
        return count;
    }

    @JsonProperty("count")
    public void setCount(Integer count) {
        this.count = count;
    }

    @JsonProperty("last_message_id")
    public String getLastMessageId() {
        return lastMessageId;
    }

    @JsonProperty("last_message_id")
    public void setLastMessageId(String lastMessageId) {
        this.lastMessageId = lastMessageId;
    }

    @JsonProperty("last_message_created_at")
    public Integer getLastMessageCreatedAt() {
        return lastMessageCreatedAt;
    }

    @JsonProperty("last_message_created_at")
    public void setLastMessageCreatedAt(Integer lastMessageCreatedAt) {
        this.lastMessageCreatedAt = lastMessageCreatedAt;
    }

    @JsonProperty("preview")
    public GroupMeMessage getPreview() {
        return preview;
    }

    @JsonProperty("preview")
    public void setPreview(GroupMeMessage preview) {
        this.preview = preview;
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