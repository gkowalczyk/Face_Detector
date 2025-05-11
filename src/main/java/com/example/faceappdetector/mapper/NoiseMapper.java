package com.example.faceappdetector.mapper;

import com.example.faceappdetector.dto.Noise;
import com.example.faceappdetector.entity.NoiseEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NoiseMapper {

    Noise toDto(NoiseEntity entity);

    NoiseEntity toEntity(Noise dto);
}
