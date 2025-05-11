package com.example.faceappdetector.response;

import com.example.faceappdetector.dto.FaceObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class FacePlusApiResponse {
    @JsonProperty("faces")
    private List<FaceObject> faces;
}