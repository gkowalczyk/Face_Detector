package com.example.faceappdetector.entity;

import lombok.Data;
import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class FacialHairEntity {
    private Double moustache;
    private Double beard;
    private Double sideburns;
    private Map<String, Object> additionalProperties = new LinkedHashMap<>();
}
