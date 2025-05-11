package com.example.faceappdetector.mapper;

import com.example.faceappdetector.dto.FaceRectangle;
import com.example.faceappdetector.entity.FaceRectangleEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FaceRectangleMapper {

    FaceRectangle toDto(FaceRectangleEntity entity);

    FaceRectangleEntity toEntity(FaceRectangle dto);
}
