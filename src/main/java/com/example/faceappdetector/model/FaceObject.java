
package com.example.faceappdetector.model;

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
    "faceRectangle",
    "faceLandmarks",
    "faceAttributes"
})
@Generated("jsonschema2pojo")
@ToString
public class FaceObject {



    @JsonProperty("faceRectangle")
    private FaceRectangle faceRectangle;
    @JsonProperty("faceLandmarks")
    private FaceLandmarks faceLandmarks;
    @JsonProperty("faceAttributes")
    private FaceAttributes faceAttributes;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("faceRectangle")
    public FaceRectangle getFaceRectangle() {
        return faceRectangle;
    }

    @JsonProperty("faceRectangle")
    public void setFaceRectangle(FaceRectangle faceRectangle) {
        this.faceRectangle = faceRectangle;
    }

    @JsonProperty("faceLandmarks")
    public FaceLandmarks getFaceLandmarks() {
        return faceLandmarks;
    }

    @JsonProperty("faceLandmarks")
    public void setFaceLandmarks(FaceLandmarks faceLandmarks) {
        this.faceLandmarks = faceLandmarks;
    }

    @JsonProperty("faceAttributes")
    public FaceAttributes getFaceAttributes() {
        return faceAttributes;
    }

    @JsonProperty("faceAttributes")
    public void setFaceAttributes(FaceAttributes faceAttributes) {
        this.faceAttributes = faceAttributes;
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
