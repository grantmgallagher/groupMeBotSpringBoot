package com.dev.groupmemodel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "type",
        "url"
})
public class GroupMeAttachmentImage implements GroupMeAttachment{
    @JsonProperty("url")
    private String url;
    @JsonProperty("type")
    private String type;

    /*
    Constructor necessary as Jackson seems to hate parsing the type, finding the correct object,
        and then passing the type down into the object during instantiation.
     */
    public GroupMeAttachmentImage()
    {
        this.type = "image";
    }

    @JsonProperty("url")
    public String getURL() {
        return url;
    }

    @JsonProperty("url")
    public void setURL(String url) {
        this.url = url;
    }

    @JsonProperty("type")
    public void setType(String t) {this.type = t;}

    @JsonProperty("type")
    public String getType() {return this.type;}

    /*
    Explicitly unused methods
     */
    public List<List<Integer>> getLoci() {
        throw new UnsupportedOperationException("Function getLoci unsupported for Class GroupMeAttachmentImage");
    }

    public void setLoci(List<List<Integer>> loci) {
        throw new UnsupportedOperationException("Function setLoci unsupported for Class GroupMeAttachmentImage");
    }

    public List<String> getUserIds() {
        throw new UnsupportedOperationException("Function getUserIds unsupported for Class GroupMeAttachmentImage");
    }

    public void setUserIds(List<String> userIds) {
        throw new UnsupportedOperationException("Function setUserIds unsupported for Class GroupMeAttachmentImage");
    }
}