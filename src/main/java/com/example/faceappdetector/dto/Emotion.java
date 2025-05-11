
package com.example.faceappdetector.dto;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "anger",
    "disgust",
    "fear",
    "happiness",
    "neutral",
    "sadness",
    "surprise"
})
@Generated("jsonschema2pojo")
public class Emotion {

    @JsonProperty("anger")
    public Double anger;
    @JsonProperty("disgust")
    public Double disgust;
    @JsonProperty("fear")
    public Double fear;
    @JsonProperty("happiness")
    public Double happiness;
    @JsonProperty("neutral")
    public Double neutral;
    @JsonProperty("sadness")
    public Double sadness;
    @JsonProperty("surprise")
    public Double surprise;

    public Emotion withAnger(Double anger) {
        this.anger = anger;
        return this;
    }

    public Emotion withDisgust(Double disgust) {
        this.disgust = disgust;
        return this;
    }

    public Emotion withFear(Double fear) {
        this.fear = fear;
        return this;
    }

    public Emotion withHappiness(Double happiness) {
        this.happiness = happiness;
        return this;
    }

    public Emotion withNeutral(Double neutral) {
        this.neutral = neutral;
        return this;
    }

    public Emotion withSadness(Double sadness) {
        this.sadness = sadness;
        return this;
    }

    public Emotion withSurprise(Double surprise) {
        this.surprise = surprise;
        return this;
    }

}
