package com.example.faceappdetector.entity;

import lombok.Data;
import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class NoseTipEntity {
    private Double x;
    private Double y;
    private Map<String, Object> additionalProperties = new LinkedHashMap<>();
}
