package com.example.faceappdetector.mapper;

import com.example.faceappdetector.dto.HeadPose;
import com.example.faceappdetector.entity.HeadPoseEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HeadPoseMapper {

    HeadPose toDto(HeadPoseEntity entity);

    HeadPoseEntity toEntity(HeadPose dto);
}
