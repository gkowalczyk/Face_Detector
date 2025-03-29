
package com.example.faceappdetector.model;

import java.util.LinkedHashMap;
import java.util.List;
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
    "smile",
    "headPose",
    "age",
    "facialHair",
    "glasses",
    "blur",
    "exposure",
    "noise",
    "makeup",
    "accessories",
    "occlusion",
    "hair",
    "qualityForRecognition"
})
@Generated("jsonschema2pojo")
@ToString
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
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("smile")
    public Double getSmile() {
        return smile;
    }

    @JsonProperty("smile")
    public void setSmile(Double smile) {
        this.smile = smile;
    }

    @JsonProperty("headPose")
    public HeadPose getHeadPose() {
        return headPose;
    }

    @JsonProperty("headPose")
    public void setHeadPose(HeadPose headPose) {
        this.headPose = headPose;
    }

    @JsonProperty("age")
    public Double getAge() {
        return age;
    }

    @JsonProperty("age")
    public void setAge(Double age) {
        this.age = age;
    }

    @JsonProperty("facialHair")
    public FacialHair getFacialHair() {
        return facialHair;
    }

    @JsonProperty("facialHair")
    public void setFacialHair(FacialHair facialHair) {
        this.facialHair = facialHair;
    }

    @JsonProperty("glasses")
    public String getGlasses() {
        return glasses;
    }

    @JsonProperty("glasses")
    public void setGlasses(String glasses) {
        this.glasses = glasses;
    }

    @JsonProperty("blur")
    public Blur getBlur() {
        return blur;
    }

    @JsonProperty("blur")
    public void setBlur(Blur blur) {
        this.blur = blur;
    }

    @JsonProperty("exposure")
    public Exposure getExposure() {
        return exposure;
    }

    @JsonProperty("exposure")
    public void setExposure(Exposure exposure) {
        this.exposure = exposure;
    }

    @JsonProperty("noise")
    public Noise getNoise() {
        return noise;
    }

    @JsonProperty("noise")
    public void setNoise(Noise noise) {
        this.noise = noise;
    }

    @JsonProperty("makeup")
    public Makeup getMakeup() {
        return makeup;
    }

    @JsonProperty("makeup")
    public void setMakeup(Makeup makeup) {
        this.makeup = makeup;
    }

    @JsonProperty("accessories")
    public List<Object> getAccessories() {
        return accessories;
    }

    @JsonProperty("accessories")
    public void setAccessories(List<Object> accessories) {
        this.accessories = accessories;
    }

    @JsonProperty("occlusion")
    public Occlusion getOcclusion() {
        return occlusion;
    }

    @JsonProperty("occlusion")
    public void setOcclusion(Occlusion occlusion) {
        this.occlusion = occlusion;
    }

    @JsonProperty("hair")
    public Hair getHair() {
        return hair;
    }

    @JsonProperty("hair")
    public void setHair(Hair hair) {
        this.hair = hair;
    }

    @JsonProperty("qualityForRecognition")
    public String getQualityForRecognition() {
        return qualityForRecognition;
    }

    @JsonProperty("qualityForRecognition")
    public void setQualityForRecognition(String qualityForRecognition) {
        this.qualityForRecognition = qualityForRecognition;
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
