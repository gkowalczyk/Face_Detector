package com.example.faceappdetector.mapper;

import com.example.faceappdetector.dto.FaceLandmarks;
import com.example.faceappdetector.entity.FaceLandmarksEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FaceLandmarksMapper {

    FaceLandmarks toDto(FaceLandmarksEntity entity);

    FaceLandmarksEntity toEntity(FaceLandmarks dto);
}
