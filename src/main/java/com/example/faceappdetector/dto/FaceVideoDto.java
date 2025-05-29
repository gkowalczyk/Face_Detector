package com.example.faceappdetector.dto;

import lombok.Data;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FaceVideoDto {

    private int id;
    private String name;
    private double confidence;
    private String description;
    private String title;
    private String thumbnailId;
    private String imageUrl;
    private String publishedUrl;
    private boolean highQuality;
    private List<ThumbnailDto> thumbnails;
    private List<InstanceDto> instances;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ThumbnailDto {
        private String id;
        private String fileName;
        private List<ThumbnailInstanceDto> instances;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ThumbnailInstanceDto {
        private String adjustedStart;
        private String adjustedEnd;
        private String start;
        private String end;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class InstanceDto {
        private List<String> thumbnailsIds;
        private String adjustedStart;
        private String adjustedEnd;
        private String start;
        private String end;
    }
}

