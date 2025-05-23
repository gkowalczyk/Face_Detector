
package com.example.faceappdetector.dto;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.ToString;

import javax.annotation.processing.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "moustache",
    "beard",
    "sideburns"
})
@Generated("jsonschema2pojo")
@ToString
public class FacialHair {

    @JsonProperty("moustache")
    private Double moustache;
    @JsonProperty("beard")
    private Double beard;
    @JsonProperty("sideburns")
    private Double sideburns;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("moustache")
    public Double getMoustache() {
        return moustache;
    }

    @JsonProperty("moustache")
    public void setMoustache(Double moustache) {
        this.moustache = moustache;
    }

    @JsonProperty("beard")
    public Double getBeard() {
        return beard;
    }

    @JsonProperty("beard")
    public void setBeard(Double beard) {
        this.beard = beard;
    }

    @JsonProperty("sideburns")
    public Double getSideburns() {
        return sideburns;
    }

    @JsonProperty("sideburns")
    public void setSideburns(Double sideburns) {
        this.sideburns = sideburns;
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
