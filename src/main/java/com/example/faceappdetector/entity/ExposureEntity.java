package com.example.faceappdetector.entity;

import lombok.Data;
import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class ExposureEntity {
    private String exposureLevel;
    private Double value;
    private Map<String, Object> additionalProperties = new LinkedHashMap<>();
}
