package com.example.faceappdetector.mapper;

import com.example.faceappdetector.dto.EyebrowLeftInner;
import com.example.faceappdetector.entity.EyebrowLeftInnerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EyebrowLeftInnerMapper {

    EyebrowLeftInner toDto(EyebrowLeftInnerEntity entity);

    EyebrowLeftInnerEntity toEntity(EyebrowLeftInner dto);
}
