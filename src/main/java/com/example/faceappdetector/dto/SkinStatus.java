
package com.example.faceappdetector.dto;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "health",
    "stain",
    "dark_circle",
    "acne"
})
@Generated("jsonschema2pojo")
public class SkinStatus {

    @JsonProperty("health")
    public Double health;
    @JsonProperty("stain")
    public Double stain;
    @JsonProperty("dark_circle")
    public Double darkCircle;
    @JsonProperty("acne")
    public Double acne;

    public SkinStatus withHealth(Double health) {
        this.health = health;
        return this;
    }

    public SkinStatus withStain(Double stain) {
        this.stain = stain;
        return this;
    }

    public SkinStatus withDarkCircle(Double darkCircle) {
        this.darkCircle = darkCircle;
        return this;
    }

    public SkinStatus withAcne(Double acne) {
        this.acne = acne;
        return this;
    }

}
