
package com.example.faceappdetector.dto;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "value"
})
@Generated("jsonschema2pojo")
public class Gender {

    @JsonProperty("value")
    public String value;

    public Gender withValue(String value) {
        this.value = value;
        return this;
    }

}
