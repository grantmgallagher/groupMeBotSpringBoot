package com.dev.groupmemodel;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "group_id",
        "name",
        "phone_number",
        "type",
        "description",
        "image_url",
        "creator_user_id",
        "created_at",
        "updated_at",
        "muted_until",
        "office_mode",
        "share_url",
        "share_qr_code_url",
        "members",
        "messages",
        "max_members"
})
public class GroupMeGroup {

    @JsonProperty("id")
    private String id;
    @JsonProperty("group_id")
    private String groupId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("phone_number")
    private String phoneNumber;
    @JsonProperty("type")
    private String type;
    @JsonProperty("description")
    private String description;
    @JsonProperty("image_url")
    private String imageUrl;
    @JsonProperty("creator_user_id")
    private String creatorUserId;
    @JsonProperty("created_at")
    private Integer createdAt;
    @JsonProperty("updated_at")
    private Integer updatedAt;
    @JsonProperty("muted_until")
    private Object mutedUntil;
    @JsonProperty("office_mode")
    private Boolean officeMode;
    @JsonProperty("share_url")
    private Object shareUrl;
    @JsonProperty("share_qr_code_url")
    private Object shareQrCodeUrl;
    @JsonProperty("members")
    private List<GroupMeMember> members = null;
    @JsonProperty("messages")
    private GroupMeGroupMessagePreview messages;
    @JsonProperty("max_members")
    private Integer maxMembers;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
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

    @JsonProperty("phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @JsonProperty("phone_number")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("image_url")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @JsonProperty("creator_user_id")
    public String getCreatorUserId() {
        return creatorUserId;
    }

    @JsonProperty("creator_user_id")
    public void setCreatorUserId(String creatorUserId) {
        this.creatorUserId = creatorUserId;
    }

    @JsonProperty("created_at")
    public Integer getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("updated_at")
    public Integer getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updated_at")
    public void setUpdatedAt(Integer updatedAt) {
        this.updatedAt = updatedAt;
    }

    @JsonProperty("muted_until")
    public Object getMutedUntil() {
        return mutedUntil;
    }

    @JsonProperty("muted_until")
    public void setMutedUntil(Object mutedUntil) {
        this.mutedUntil = mutedUntil;
    }

    @JsonProperty("office_mode")
    public Boolean getOfficeMode() {
        return officeMode;
    }

    @JsonProperty("office_mode")
    public void setOfficeMode(Boolean officeMode) {
        this.officeMode = officeMode;
    }

    @JsonProperty("share_url")
    public Object getShareUrl() {
        return shareUrl;
    }

    @JsonProperty("share_url")
    public void setShareUrl(Object shareUrl) {
        this.shareUrl = shareUrl;
    }

    @JsonProperty("share_qr_code_url")
    public Object getShareQrCodeUrl() {
        return shareQrCodeUrl;
    }

    @JsonProperty("share_qr_code_url")
    public void setShareQrCodeUrl(Object shareQrCodeUrl) {
        this.shareQrCodeUrl = shareQrCodeUrl;
    }

    @JsonProperty("members")
    public List<GroupMeMember> getMembers() {
        return members;
    }

    @JsonProperty("members")
    public void setMembers(List<GroupMeMember> members) {
        this.members = members;
    }

    @JsonProperty("messages")
    public GroupMeGroupMessagePreview getMessages() {
        return messages;
    }

    @JsonProperty("messages")
    public void setMessages(GroupMeGroupMessagePreview messages) {
        this.messages = messages;
    }

    @JsonProperty("max_members")
    public Integer getMaxMembers() {
        return maxMembers;
    }

    @JsonProperty("max_members")
    public void setMaxMembers(Integer maxMembers) {
        this.maxMembers = maxMembers;
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