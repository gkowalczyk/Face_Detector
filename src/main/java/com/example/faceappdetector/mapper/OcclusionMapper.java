package com.example.faceappdetector.mapper;

import com.example.faceappdetector.dto.Occlusion;
import com.example.faceappdetector.entity.OcclusionEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OcclusionMapper {

    Occlusion toDto(OcclusionEntity entity);

    OcclusionEntity toEntity(Occlusion dto);
}
