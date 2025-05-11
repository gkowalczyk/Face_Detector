package com.example.faceappdetector.entity;

import lombok.Data;
import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class MakeupEntity {
    private Boolean eyeMakeup;
    private Boolean lipMakeup;
    private Map<String, Object> additionalProperties = new LinkedHashMap<>();
}
