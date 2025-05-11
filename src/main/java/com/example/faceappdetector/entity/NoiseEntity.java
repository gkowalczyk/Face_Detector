package com.example.faceappdetector.entity;

import lombok.Data;
import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class NoiseEntity {
    private String noiseLevel;
    private Double value;
    private Map<String, Object> additionalProperties = new LinkedHashMap<>();
}
