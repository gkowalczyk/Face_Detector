package com.example.faceappdetector.mapper;

import com.example.faceappdetector.dto.Blur;
import com.example.faceappdetector.entity.BlurEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BlurMapper {

    Blur toDto(BlurEntity entity);

    BlurEntity toEntity(Blur dto);
}
