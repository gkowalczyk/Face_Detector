
package com.example.faceappdetector.dto;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "male_score",
    "female_score"
})
@Generated("jsonschema2pojo")
public class Beauty {

    @JsonProperty("male_score")
    public Double maleScore;
    @JsonProperty("female_score")
    public Double femaleScore;

    public Beauty withMaleScore(Double maleScore) {
        this.maleScore = maleScore;
        return this;
    }

    public Beauty withFemaleScore(Double femaleScore) {
        this.femaleScore = femaleScore;
        return this;
    }
}
