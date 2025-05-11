package com.example.faceappdetector.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
@Document
public class FaceObjectEntity {
    @Id
    private String id;
    private String faceToken;
    private FaceRectangleEntity faceRectangle;
    private String url;
    private FaceLandmarksEntity faceLandmarks;
    private FaceAttributesEntity faceAttributes;
    private Map<String, Object> additionalProperties = new LinkedHashMap<>();
}
