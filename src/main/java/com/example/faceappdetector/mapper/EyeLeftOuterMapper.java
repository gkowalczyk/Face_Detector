package com.example.faceappdetector.mapper;

import com.example.faceappdetector.dto.EyeLeftOuter;
import com.example.faceappdetector.entity.EyeLeftOuterEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EyeLeftOuterMapper {

    EyeLeftOuter toDto(EyeLeftOuterEntity entity);

    EyeLeftOuterEntity toEntity(EyeLeftOuter dto);
}
