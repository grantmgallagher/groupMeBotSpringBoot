package com.dev.groupmemodel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "loci",
        "type",
        "user_ids"
})
public class GroupMeAttachmentMention implements GroupMeAttachment{
    @JsonProperty("type")
    private String type;
    @JsonProperty("loci")
    private List<List<Integer>> loci = null;
    @JsonProperty("user_ids")
    private List<String> userIds = null;

    /*
    Constructor necessary as Jackson seems to hate parsing the type, finding the correct object,
        and then passing the type down into the object during instantiation.
     */
    public GroupMeAttachmentMention()
    {
        this.type = "mentions";
        this.loci = new ArrayList<List<Integer>>();
        this.userIds = new ArrayList<String>();
    }

    @JsonProperty("loci")
    public List<List<Integer>> getLoci() {
        return loci;
    }

    @JsonProperty("loci")
    public void setLoci(List<List<Integer>> loci) {
        this.loci = loci;
    }

    @JsonProperty("user_ids")
    public List<String> getUserIds() {
        return userIds;
    }

    @JsonProperty("user_ids")
    public void setUserIds(List<String> userIds) {
        this.userIds = userIds;
    }

    @JsonProperty("type")
    public void setType(String t) {this.type = t;}

    @JsonProperty("type")
    public String getType() {return this.type;}

    /*
    Explicitly unused methods
     */
    public String getURL() {
        throw new UnsupportedOperationException("Function getURL unsupported for Class GroupMeAttachmentMention");
    }

    public void setURL(String url) {
        throw new UnsupportedOperationException("Function setURL unsupported for Class GroupMeAttachmentMention");
    }

}
