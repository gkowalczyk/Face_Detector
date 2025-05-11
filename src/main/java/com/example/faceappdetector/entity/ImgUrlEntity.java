package com.example.faceappdetector.entity;

import lombok.Data;
import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class ImgUrlEntity {
    private String url;
    private Map<String, Object> additionalProperties = new LinkedHashMap<>();
}
