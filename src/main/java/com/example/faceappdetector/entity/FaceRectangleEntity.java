package com.example.faceappdetector.entity;

import lombok.Data;
import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class FaceRectangleEntity {
    private Integer top;
    private Integer left;
    private Integer width;
    private Integer height;
    private Map<String, Object> additionalProperties = new LinkedHashMap<>();
}
