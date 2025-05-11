package com.example.faceappdetector.entity;

import lombok.Data;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Data
public class HairEntity {
    private Double bald;
    private Boolean invisible;
    private List<HairColorEntity> hairColor;
    private Map<String, Object> additionalProperties = new LinkedHashMap<>();
}
