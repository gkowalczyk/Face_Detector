
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
    "pitch",
    "roll",
    "yaw"
})
@Generated("jsonschema2pojo")
@ToString
public class HeadPose {

    @JsonProperty("pitch")
    private Double pitch;
    @JsonProperty("roll")
    private Double roll;
    @JsonProperty("yaw")
    private Double yaw;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("pitch")
    public Double getPitch() {
        return pitch;
    }

    @JsonProperty("pitch")
    public void setPitch(Double pitch) {
        this.pitch = pitch;
    }

    @JsonProperty("roll")
    public Double getRoll() {
        return roll;
    }

    @JsonProperty("roll")
    public void setRoll(Double roll) {
        this.roll = roll;
    }

    @JsonProperty("yaw")
    public Double getYaw() {
        return yaw;
    }

    @JsonProperty("yaw")
    public void setYaw(Double yaw) {
        this.yaw = yaw;
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
