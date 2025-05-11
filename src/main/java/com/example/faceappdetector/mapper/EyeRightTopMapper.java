package com.example.faceappdetector.mapper;

import com.example.faceappdetector.dto.EyeRightTop;
import com.example.faceappdetector.entity.EyeRightTopEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EyeRightTopMapper {

    EyeRightTop toDto(EyeRightTopEntity entity);

    EyeRightTopEntity toEntity(EyeRightTop dto);
}
