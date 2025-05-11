package com.example.faceappdetector.entity;

import lombok.Data;
import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class HeadPoseEntity {
    private Double pitch;
    private Double roll;
    private Double yaw;
    private Map<String, Object> additionalProperties = new LinkedHashMap<>();
}
