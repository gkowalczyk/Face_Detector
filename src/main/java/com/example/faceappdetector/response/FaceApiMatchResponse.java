package com.example.faceappdetector.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.annotation.processing.Generated;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
public class FaceApiMatchResponse {

    @JsonProperty("thresholds")
    private Thresholds thresholds;
    @JsonProperty("results")
    private List<Result> results;

    @Data
    public static class Thresholds {
        @JsonProperty("1e-3")
        private double _1e_3;

        @JsonProperty("1e-4")
        private double _1e_4;

        @JsonProperty("1e-5")
        private double _1e_5;
    }

    @Data
    public static class Result {
        @JsonProperty("confidence")
        private double confidence;
        @JsonProperty("face_token")
        private String faceToken;
    }
}