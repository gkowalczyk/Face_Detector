package com.example.faceappdetector.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "smile", "headPose", "age", "facialHair", "glasses", "blur", "exposure",
        "noise", "makeup", "accessories", "occlusion", "hair", "qualityForRecognition",
        "gender", "emotion", "beauty", "skinstatus"
})
@Data
public class FaceAttributes {

    @JsonProperty("smile")
    private Double smile;

    @JsonProperty("headPose")
    private HeadPose headPose;

    @JsonProperty("age")
    private Double age;

    @JsonProperty("facialHair")
    private FacialHair facialHair;

    @JsonProperty("glasses")
    private String glasses;

    @JsonProperty("blur")
    private Blur blur;

    @JsonProperty("exposure")
    private Exposure exposure;

    @JsonProperty("noise")
    private Noise noise;

    @JsonProperty("makeup")
    private Makeup makeup;

    @JsonProperty("accessories")
    private List<Object> accessories;

    @JsonProperty("occlusion")
    private Occlusion occlusion;

    @JsonProperty("hair")
    private Hair hair;

    @JsonProperty("qualityForRecognition")
    private String qualityForRecognition;

    @JsonProperty("gender")
    private Gender gender;

    @JsonProperty("emotion")
    private Emotion emotion;

    @JsonProperty("beauty")
    private Beauty beauty;

    @JsonProperty("skinstatus")
    private SkinStatus skinstatus;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
