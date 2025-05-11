package com.example.faceappdetector.mapper;

import com.example.faceappdetector.dto.Exposure;
import com.example.faceappdetector.entity.ExposureEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExposureMapper {

    Exposure toDto(ExposureEntity entity);

    ExposureEntity toEntity(Exposure dto);
}
