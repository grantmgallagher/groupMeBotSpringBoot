package com.dev.groupmemodel;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.List;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = GroupMeAttachmentMention.class, name = "mentions"),

        @JsonSubTypes.Type(value = GroupMeAttachmentImage.class, name = "image")
        }
)
public interface GroupMeAttachment {
    /*
    Common Functions
     */
    public void setType(String t);

    public String getType();

    /*
    Functions for Images
     */
    abstract void setURL(String url);

    abstract String getURL();

    /*
    Functions for mentions
     */
    abstract List<List<Integer>> getLoci();

    abstract void setLoci(List<List<Integer>> loci);

    abstract List<String> getUserIds();

    abstract void setUserIds(List<String> userIds);
}
