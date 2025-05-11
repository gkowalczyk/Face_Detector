package com.example.faceappdetector.mapper;

import com.example.faceappdetector.dto.FaceAttributes;
import com.example.faceappdetector.dto.SkinStatus;
import com.example.faceappdetector.entity.FaceAttributesEntity;
import com.example.faceappdetector.entity.SkinStatusEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FaceAttributesMapper {

    FaceAttributes toDto(FaceAttributesEntity entity);


    FaceAttributesEntity toEntity(FaceAttributes dto);
}
