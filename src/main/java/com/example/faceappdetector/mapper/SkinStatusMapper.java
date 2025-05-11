package com.example.faceappdetector.mapper;

import com.example.faceappdetector.dto.SkinStatus;
import com.example.faceappdetector.entity.SkinStatusEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SkinStatusMapper {
    SkinStatus toDto(SkinStatusEntity entity);
    SkinStatusEntity toEntity(SkinStatus dto);
}
