package com.dev.groupmemodel;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
/*@JsonPropertyOrder({
        "id",
        "source_guid",
        "created_at",
        "user_id",
        "group_id",
        "name",
        "avatar_url",
        "text",
        "system",
        "favorited_by",
        "attachments"
})*/
public class GroupMeMessage {
    @JsonProperty("sender_id")
    private String senderId;
    @JsonProperty("sender_type")
    private String senderType;
    @JsonProperty("platform")
    private String platform;
    @JsonProperty("id")
    private String id;
    @JsonProperty("source_guid")
    private String sourceGuid;
    @JsonProperty("created_at")
    private Integer createdAt;
    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("group_id")
    private String groupId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("avatar_url")
    private String avatarUrl;
    @JsonProperty("text")
    private String text;
    @JsonProperty("system")
    private Boolean system;
    @JsonProperty("favorited_by")
    private List<Integer> favoritedBy = null;
    @JsonProperty("attachments")
    private List<GroupMeAttachment> attachments = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("sender_id")
    public String getSenderId() {
        return senderId;
    }

    @JsonProperty("sender_id")
    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    @JsonProperty("sender_type")
    public String getSenderType() {
        return senderType;
    }

    @JsonProperty("sender_type")
    public void setSenderType(String senderType) {
        this.senderType = senderType;
    }

    @JsonProperty("platform")
    public String getPlatform() {
        return platform;
    }

    @JsonProperty("platform")
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("source_guid")
    public String getSourceGuid() {
        return sourceGuid;
    }

    @JsonProperty("source_guid")
    public void setSourceGuid(String sourceGuid) {
        this.sourceGuid = sourceGuid;
    }

    @JsonProperty("created_at")
    public Integer getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("user_id")
    public String getUserId() {
        return userId;
    }

    @JsonProperty("user_id")
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @JsonProperty("group_id")
    public String getGroupId() {
        return groupId;
    }

    @JsonProperty("group_id")
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("avatar_url")
    public String getAvatarUrl() {
        return avatarUrl;
    }

    @JsonProperty("avatar_url")
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("system")
    public Boolean getSystem() {
        return system;
    }

    @JsonProperty("system")
    public void setSystem(Boolean system) {
        this.system = system;
    }

    @JsonProperty("favorited_by")
    public List<Integer> getFavoritedBy() {
        return favoritedBy;
    }

    @JsonProperty("favorited_by")
    public void setFavoritedBy(List<Integer> favoritedBy) {
        this.favoritedBy = favoritedBy;
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