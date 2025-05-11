package com.example.faceappdetector.entity;

import lombok.Data;
import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class HairColorEntity {
    private String color;
    private Double confidence;
    private Map<String, Object> additionalProperties = new LinkedHashMap<>();
}
