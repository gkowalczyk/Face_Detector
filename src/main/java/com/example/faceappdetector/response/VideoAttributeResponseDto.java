package com.example.faceappdetector.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "accountId", "id", "partition", "externalId", "metadata", "name", "description",
        "created", "lastModified", "lastIndexed", "privacyMode", "userName",
        "isOwned", "isBase", "hasSourceVideoFile", "state", "moderationState",
        "reviewState", "isSearchable", "processingProgress", "durationInSeconds"
})
@Data
@Builder
public class VideoAttributeResponseDto {


    @JsonProperty("accountId")
    private String accountId;

    @JsonProperty("id")
    private String id;

    @JsonProperty("partition")
    private Object partition;

    @JsonProperty("externalId")
    private Object externalId;

    @JsonProperty("metadata")
    private Object metadata;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private Object description;

    @JsonProperty("created")
    private String created;

    @JsonProperty("lastModified")
    private String lastModified;

    @JsonProperty("lastIndexed")
    private String lastIndexed;

    @JsonProperty("privacyMode")
    private String privacyMode;

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("isOwned")
    private Boolean isOwned;

    @JsonProperty("isBase")
    private Boolean isBase;

    @JsonProperty("hasSourceVideoFile")
    private Boolean hasSourceVideoFile;

    @JsonProperty("state")
    private String state;

    @JsonProperty("moderationState")
    private String moderationState;

    @JsonProperty("reviewState")
    private String reviewState;

    @JsonProperty("isSearchable")
    private Boolean isSearchable;

    @JsonProperty("processingProgress")
    private String processingProgress;

    @JsonProperty("durationInSeconds")
    private Integer durationInSeconds;
}
