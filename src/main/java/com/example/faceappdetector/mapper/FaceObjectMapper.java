package com.example.faceappdetector.mapper;

import com.example.faceappdetector.dto.FaceObject;
import com.example.faceappdetector.entity.FaceObjectEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FaceObjectMapper {

    FaceObject toDto(FaceObjectEntity entity);

    FaceObjectEntity toEntity(FaceObject dto);
}
