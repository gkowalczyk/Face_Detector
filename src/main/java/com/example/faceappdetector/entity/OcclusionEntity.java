package com.example.faceappdetector.entity;

import lombok.Data;
import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class OcclusionEntity {
    private Boolean foreheadOccluded;
    private Boolean eyeOccluded;
    private Boolean mouthOccluded;
    private Map<String, Object> additionalProperties = new LinkedHashMap<>();
}
