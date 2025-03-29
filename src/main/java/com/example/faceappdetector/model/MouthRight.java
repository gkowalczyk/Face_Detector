
package com.example.faceappdetector.model;

import com.fasterxml.jackson.annotation.*;
import lombok.ToString;

import javax.annotation.processing.Generated;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "x",
    "y"
})
@Generated("jsonschema2pojo")
@ToString
public class MouthRight {

    @JsonProperty("x")
    private Double x;
    @JsonProperty("y")
    private Double y;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("x")
    public Double getX() {
        return x;
    }

    @JsonProperty("x")
    public void setX(Double x) {
        this.x = x;
    }

    @JsonProperty("y")
    public Double getY() {
        return y;
    }

    @JsonProperty("y")
    public void setY(Double y) {
        this.y = y;
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
