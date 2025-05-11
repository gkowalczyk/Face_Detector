package com.example.faceappdetector.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Data
public class FaceAttributesEntity {
    private Double smile;
    private HeadPoseEntity headPose;
    private Double age;
    private FacialHairEntity facialHair;
    private String glasses;
    private BlurEntity blur;
    private ExposureEntity exposure;
    private NoiseEntity noise;
    private MakeupEntity makeup;
    private List<Object> accessories;
    private OcclusionEntity occlusion;
    private HairEntity hair;
    private String qualityForRecognition;
    private GenderEntity gender;
    private EmotionEntity emotion;
    private BeautyEntity beauty;
    private SkinStatusEntity skinstatus;
    private Map<String, Object> additionalProperties = new LinkedHashMap<>();
}
