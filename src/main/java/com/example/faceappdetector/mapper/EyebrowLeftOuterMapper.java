package com.example.faceappdetector.mapper;

import com.example.faceappdetector.dto.EyebrowLeftOuter;
import com.example.faceappdetector.entity.EyebrowLeftOuterEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EyebrowLeftOuterMapper {

    EyebrowLeftOuter toDto(EyebrowLeftOuterEntity entity);

    EyebrowLeftOuterEntity toEntity(EyebrowLeftOuter dto);
}
