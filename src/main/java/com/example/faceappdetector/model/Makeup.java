
package com.example.faceappdetector.model;

import com.fasterxml.jackson.annotation.*;
import lombok.ToString;

import javax.annotation.processing.Generated;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "eyeMakeup",
    "lipMakeup"
})
@Generated("jsonschema2pojo")
@ToString
public class Makeup {

    @JsonProperty("eyeMakeup")
    private Boolean eyeMakeup;
    @JsonProperty("lipMakeup")
    private Boolean lipMakeup;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("eyeMakeup")
    public Boolean getEyeMakeup() {
        return eyeMakeup;
    }

    @JsonProperty("eyeMakeup")
    public void setEyeMakeup(Boolean eyeMakeup) {
        this.eyeMakeup = eyeMakeup;
    }

    @JsonProperty("lipMakeup")
    public Boolean getLipMakeup() {
        return lipMakeup;
    }

    @JsonProperty("lipMakeup")
    public void setLipMakeup(Boolean lipMakeup) {
        this.lipMakeup = lipMakeup;
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
