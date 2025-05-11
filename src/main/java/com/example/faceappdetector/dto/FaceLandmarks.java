
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
    "pupilLeft",
    "pupilRight",
    "noseTip",
    "mouthLeft",
    "mouthRight",
    "eyebrowLeftOuter",
    "eyebrowLeftInner",
    "eyeLeftOuter",
    "eyeLeftTop",
    "eyeLeftBottom",
    "eyeLeftInner",
    "eyebrowRightInner",
    "eyebrowRightOuter",
    "eyeRightInner",
    "eyeRightTop",
    "eyeRightBottom",
    "eyeRightOuter",
    "noseRootLeft",
    "noseRootRight",
    "noseLeftAlarTop",
    "noseRightAlarTop",
    "noseLeftAlarOutTip",
    "noseRightAlarOutTip",
    "upperLipTop",
    "upperLipBottom",
    "underLipTop",
    "underLipBottom"
})
@Generated("jsonschema2pojo")
@ToString
public class FaceLandmarks {

    @JsonProperty("pupilLeft")
    private PupilLeft pupilLeft;
    @JsonProperty("pupilRight")
    private PupilRight pupilRight;
    @JsonProperty("noseTip")
    private NoseTip noseTip;
    @JsonProperty("mouthLeft")
    private MouthLeft mouthLeft;
    @JsonProperty("mouthRight")
    private MouthRight mouthRight;
    @JsonProperty("eyebrowLeftOuter")
    private EyebrowLeftOuter eyebrowLeftOuter;
    @JsonProperty("eyebrowLeftInner")
    private EyebrowLeftInner eyebrowLeftInner;
    @JsonProperty("eyeLeftOuter")
    private EyeLeftOuter eyeLeftOuter;
    @JsonProperty("eyeLeftTop")
    private EyeLeftTop eyeLeftTop;
    @JsonProperty("eyeLeftBottom")
    private EyeLeftBottom eyeLeftBottom;
    @JsonProperty("eyeLeftInner")
    private EyeLeftInner eyeLeftInner;
    @JsonProperty("eyebrowRightInner")
    private EyebrowRightInner eyebrowRightInner;
    @JsonProperty("eyebrowRightOuter")
    private EyebrowRightOuter eyebrowRightOuter;
    @JsonProperty("eyeRightInner")
    private EyeRightInner eyeRightInner;
    @JsonProperty("eyeRightTop")
    private EyeRightTop eyeRightTop;
    @JsonProperty("eyeRightBottom")
    private EyeRightBottom eyeRightBottom;
    @JsonProperty("eyeRightOuter")
    private EyeRightOuter eyeRightOuter;
    @JsonProperty("noseRootLeft")
    private NoseRootLeft noseRootLeft;
    @JsonProperty("noseRootRight")
    private NoseRootRight noseRootRight;
    @JsonProperty("noseLeftAlarTop")
    private NoseLeftAlarTop noseLeftAlarTop;
    @JsonProperty("noseRightAlarTop")
    private NoseRightAlarTop noseRightAlarTop;
    @JsonProperty("noseLeftAlarOutTip")
    private NoseLeftAlarOutTip noseLeftAlarOutTip;
    @JsonProperty("noseRightAlarOutTip")
    private NoseRightAlarOutTip noseRightAlarOutTip;
    @JsonProperty("upperLipTop")
    private UpperLipTop upperLipTop;
    @JsonProperty("upperLipBottom")
    private UpperLipBottom upperLipBottom;
    @JsonProperty("underLipTop")
    private UnderLipTop underLipTop;
    @JsonProperty("underLipBottom")
    private UnderLipBottom underLipBottom;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("pupilLeft")
    public PupilLeft getPupilLeft() {
        return pupilLeft;
    }

    @JsonProperty("pupilLeft")
    public void setPupilLeft(PupilLeft pupilLeft) {
        this.pupilLeft = pupilLeft;
    }

    @JsonProperty("pupilRight")
    public PupilRight getPupilRight() {
        return pupilRight;
    }

    @JsonProperty("pupilRight")
    public void setPupilRight(PupilRight pupilRight) {
        this.pupilRight = pupilRight;
    }

    @JsonProperty("noseTip")
    public NoseTip getNoseTip() {
        return noseTip;
    }

    @JsonProperty("noseTip")
    public void setNoseTip(NoseTip noseTip) {
        this.noseTip = noseTip;
    }

    @JsonProperty("mouthLeft")
    public MouthLeft getMouthLeft() {
        return mouthLeft;
    }

    @JsonProperty("mouthLeft")
    public void setMouthLeft(MouthLeft mouthLeft) {
        this.mouthLeft = mouthLeft;
    }

    @JsonProperty("mouthRight")
    public MouthRight getMouthRight() {
        return mouthRight;
    }

    @JsonProperty("mouthRight")
    public void setMouthRight(MouthRight mouthRight) {
        this.mouthRight = mouthRight;
    }

    @JsonProperty("eyebrowLeftOuter")
    public EyebrowLeftOuter getEyebrowLeftOuter() {
        return eyebrowLeftOuter;
    }

    @JsonProperty("eyebrowLeftOuter")
    public void setEyebrowLeftOuter(EyebrowLeftOuter eyebrowLeftOuter) {
        this.eyebrowLeftOuter = eyebrowLeftOuter;
    }

    @JsonProperty("eyebrowLeftInner")
    public EyebrowLeftInner getEyebrowLeftInner() {
        return eyebrowLeftInner;
    }

    @JsonProperty("eyebrowLeftInner")
    public void setEyebrowLeftInner(EyebrowLeftInner eyebrowLeftInner) {
        this.eyebrowLeftInner = eyebrowLeftInner;
    }

    @JsonProperty("eyeLeftOuter")
    public EyeLeftOuter getEyeLeftOuter() {
        return eyeLeftOuter;
    }

    @JsonProperty("eyeLeftOuter")
    public void setEyeLeftOuter(EyeLeftOuter eyeLeftOuter) {
        this.eyeLeftOuter = eyeLeftOuter;
    }

    @JsonProperty("eyeLeftTop")
    public EyeLeftTop getEyeLeftTop() {
        return eyeLeftTop;
    }

    @JsonProperty("eyeLeftTop")
    public void setEyeLeftTop(EyeLeftTop eyeLeftTop) {
        this.eyeLeftTop = eyeLeftTop;
    }

    @JsonProperty("eyeLeftBottom")
    public EyeLeftBottom getEyeLeftBottom() {
        return eyeLeftBottom;
    }

    @JsonProperty("eyeLeftBottom")
    public void setEyeLeftBottom(EyeLeftBottom eyeLeftBottom) {
        this.eyeLeftBottom = eyeLeftBottom;
    }

    @JsonProperty("eyeLeftInner")
    public EyeLeftInner getEyeLeftInner() {
        return eyeLeftInner;
    }

    @JsonProperty("eyeLeftInner")
    public void setEyeLeftInner(EyeLeftInner eyeLeftInner) {
        this.eyeLeftInner = eyeLeftInner;
    }

    @JsonProperty("eyebrowRightInner")
    public EyebrowRightInner getEyebrowRightInner() {
        return eyebrowRightInner;
    }

    @JsonProperty("eyebrowRightInner")
    public void setEyebrowRightInner(EyebrowRightInner eyebrowRightInner) {
        this.eyebrowRightInner = eyebrowRightInner;
    }

    @JsonProperty("eyebrowRightOuter")
    public EyebrowRightOuter getEyebrowRightOuter() {
        return eyebrowRightOuter;
    }

    @JsonProperty("eyebrowRightOuter")
    public void setEyebrowRightOuter(EyebrowRightOuter eyebrowRightOuter) {
        this.eyebrowRightOuter = eyebrowRightOuter;
    }

    @JsonProperty("eyeRightInner")
    public EyeRightInner getEyeRightInner() {
        return eyeRightInner;
    }

    @JsonProperty("eyeRightInner")
    public void setEyeRightInner(EyeRightInner eyeRightInner) {
        this.eyeRightInner = eyeRightInner;
    }

    @JsonProperty("eyeRightTop")
    public EyeRightTop getEyeRightTop() {
        return eyeRightTop;
    }

    @JsonProperty("eyeRightTop")
    public void setEyeRightTop(EyeRightTop eyeRightTop) {
        this.eyeRightTop = eyeRightTop;
    }

    @JsonProperty("eyeRightBottom")
    public EyeRightBottom getEyeRightBottom() {
        return eyeRightBottom;
    }

    @JsonProperty("eyeRightBottom")
    public void setEyeRightBottom(EyeRightBottom eyeRightBottom) {
        this.eyeRightBottom = eyeRightBottom;
    }

    @JsonProperty("eyeRightOuter")
    public EyeRightOuter getEyeRightOuter() {
        return eyeRightOuter;
    }

    @JsonProperty("eyeRightOuter")
    public void setEyeRightOuter(EyeRightOuter eyeRightOuter) {
        this.eyeRightOuter = eyeRightOuter;
    }

    @JsonProperty("noseRootLeft")
    public NoseRootLeft getNoseRootLeft() {
        return noseRootLeft;
    }

    @JsonProperty("noseRootLeft")
    public void setNoseRootLeft(NoseRootLeft noseRootLeft) {
        this.noseRootLeft = noseRootLeft;
    }

    @JsonProperty("noseRootRight")
    public NoseRootRight getNoseRootRight() {
        return noseRootRight;
    }

    @JsonProperty("noseRootRight")
    public void setNoseRootRight(NoseRootRight noseRootRight) {
        this.noseRootRight = noseRootRight;
    }

    @JsonProperty("noseLeftAlarTop")
    public NoseLeftAlarTop getNoseLeftAlarTop() {
        return noseLeftAlarTop;
    }

    @JsonProperty("noseLeftAlarTop")
    public void setNoseLeftAlarTop(NoseLeftAlarTop noseLeftAlarTop) {
        this.noseLeftAlarTop = noseLeftAlarTop;
    }

    @JsonProperty("noseRightAlarTop")
    public NoseRightAlarTop getNoseRightAlarTop() {
        return noseRightAlarTop;
    }

    @JsonProperty("noseRightAlarTop")
    public void setNoseRightAlarTop(NoseRightAlarTop noseRightAlarTop) {
        this.noseRightAlarTop = noseRightAlarTop;
    }

    @JsonProperty("noseLeftAlarOutTip")
    public NoseLeftAlarOutTip getNoseLeftAlarOutTip() {
        return noseLeftAlarOutTip;
    }

    @JsonProperty("noseLeftAlarOutTip")
    public void setNoseLeftAlarOutTip(NoseLeftAlarOutTip noseLeftAlarOutTip) {
        this.noseLeftAlarOutTip = noseLeftAlarOutTip;
    }

    @JsonProperty("noseRightAlarOutTip")
    public NoseRightAlarOutTip getNoseRightAlarOutTip() {
        return noseRightAlarOutTip;
    }

    @JsonProperty("noseRightAlarOutTip")
    public void setNoseRightAlarOutTip(NoseRightAlarOutTip noseRightAlarOutTip) {
        this.noseRightAlarOutTip = noseRightAlarOutTip;
    }

    @JsonProperty("upperLipTop")
    public UpperLipTop getUpperLipTop() {
        return upperLipTop;
    }

    @JsonProperty("upperLipTop")
    public void setUpperLipTop(UpperLipTop upperLipTop) {
        this.upperLipTop = upperLipTop;
    }

    @JsonProperty("upperLipBottom")
    public UpperLipBottom getUpperLipBottom() {
        return upperLipBottom;
    }

    @JsonProperty("upperLipBottom")
    public void setUpperLipBottom(UpperLipBottom upperLipBottom) {
        this.upperLipBottom = upperLipBottom;
    }

    @JsonProperty("underLipTop")
    public UnderLipTop getUnderLipTop() {
        return underLipTop;
    }

    @JsonProperty("underLipTop")
    public void setUnderLipTop(UnderLipTop underLipTop) {
        this.underLipTop = underLipTop;
    }

    @JsonProperty("underLipBottom")
    public UnderLipBottom getUnderLipBottom() {
        return underLipBottom;
    }

    @JsonProperty("underLipBottom")
    public void setUnderLipBottom(UnderLipBottom underLipBottom) {
        this.underLipBottom = underLipBottom;
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
