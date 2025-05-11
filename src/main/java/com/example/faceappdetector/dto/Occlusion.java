
package com.example.faceappdetector.dto;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "foreheadOccluded",
    "eyeOccluded",
    "mouthOccluded"
})
@Generated("jsonschema2pojo")
@ToString
public class Occlusion {

    @JsonProperty("foreheadOccluded")
    private Boolean foreheadOccluded;
    @JsonProperty("eyeOccluded")
    private Boolean eyeOccluded;
    @JsonProperty("mouthOccluded")
    private Boolean mouthOccluded;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("foreheadOccluded")
    public Boolean getForeheadOccluded() {
        return foreheadOccluded;
    }

    @JsonProperty("foreheadOccluded")
    public void setForeheadOccluded(Boolean foreheadOccluded) {
        this.foreheadOccluded = foreheadOccluded;
    }

    @JsonProperty("eyeOccluded")
    public Boolean getEyeOccluded() {
        return eyeOccluded;
    }

    @JsonProperty("eyeOccluded")
    public void setEyeOccluded(Boolean eyeOccluded) {
        this.eyeOccluded = eyeOccluded;
    }

    @JsonProperty("mouthOccluded")
    public Boolean getMouthOccluded() {
        return mouthOccluded;
    }

    @JsonProperty("mouthOccluded")
    public void setMouthOccluded(Boolean mouthOccluded) {
        this.mouthOccluded = mouthOccluded;
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
