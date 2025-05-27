package com.example.faceappdetector.dto;

import java.util.LinkedHashMap;
import java.util.Map;
import lombok.Data;
import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "faceRectangle",
        "faceLandmarks",
        "faceAttributes"
})
@Data
public class FaceObject {

    @JsonProperty("face_token")
    private String faceToken;

    private String url;

    private String id;

    @JsonProperty("faceRectangle")
    private FaceRectangle faceRectangle;

    @JsonProperty("faceLandmarks")
    private FaceLandmarks faceLandmarks;

    @JsonAlias({"faceAttributes", "attributes"})
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
