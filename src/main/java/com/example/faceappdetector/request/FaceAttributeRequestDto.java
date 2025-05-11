package com.example.faceappdetector.request;

import lombok.Data;

import java.util.List;

@Data
public class FaceAttributeRequestDto {
    private Double ageMin;
    private Double ageMax;
    private String gender;
    private Double smile;
    private Double smileMin;
    private Double smileMax;
    private Double moustacheMin;
    private Double moustacheMax;
    private Double beardMin;
    private Double beardMax;
    private Double sideburnsMin;
    private Double sideburnsMax;
    private HeadPose headPose;
    private FacialHair facialHair;
    private String glasses;
    private Blur blur;
    private Exposure exposure;
    private Noise noise;
    private Makeup makeup;
    private Occlusion occlusion;
    private Double hairBaldMin;
    private Double hairBaldMax;
    private Hair hair;
    private String hairColor;
    private String qualityForRecognition;
    private Emotion emotion;
    private SkinStatus skinStatus;

    @Data
    public static class HeadPose {
        private Double pitch;
        private Double roll;
        private Double yaw;
    }

    @Data
    public static class FacialHair {
        private Double moustache;
        private Double beard;
        private Double sideburns;
    }

    @Data
    public static class Blur {
        private String blurLevel;
        private Double value;
    }

    @Data
    public static class Exposure {
        private String exposureLevel;
        private Double value;
    }

    @Data
    public static class Noise {
        private String noiseLevel;
        private Double value;
    }

    @Data
    public static class Makeup {
        private Boolean eyeMakeup;
        private Boolean lipMakeup;
    }

    @Data
    public static class Occlusion {
        private Boolean foreheadOccluded;
        private Boolean eyeOccluded;
        private Boolean mouthOccluded;
    }

    @Data
    public static class Hair {
        private Double bald;
        private Boolean invisible;
        private List<HairColor> hairColor;
    }

    @Data
    public static class HairColor {
        private String color;
        private Double confidence;
    }

    @Data
    public static class Emotion {
        public Double anger;
        public Double disgust;
        public Double fear;
        public Double happiness;
        public Double neutral;
        public Double sadness;
        public Double surprise;
    }

    @Data
    public static class SkinStatus {
        public Double health;
        public Double stain;
        public Double darkCircle;
        public Double acne;
    }
}
