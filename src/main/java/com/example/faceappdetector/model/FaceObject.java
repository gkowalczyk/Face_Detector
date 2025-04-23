package com.example.faceappdetector.model;

import java.util.LinkedHashMap;
import java.util.Map;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "faceRectangle",
        "faceLandmarks",
        "faceAttributes"
})
@Document
@ToString
@RequiredArgsConstructor
@Data
public class FaceObject {

    @Id
    private String id;

    @JsonProperty("faceRectangle")
    private FaceRectangle faceRectangle;

    private String imageUrl;

    @JsonProperty("faceLandmarks")
    private FaceLandmarks faceLandmarks;

    @JsonProperty("faceAttributes")
    private FaceAttributes faceAttributes;

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
