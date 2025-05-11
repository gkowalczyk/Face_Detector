
package com.example.faceappdetector.entity;

import lombok.Data;
import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class EyeRightOuterEntity {


    private Double x;
    private Double y;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();
}