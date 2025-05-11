package com.example.faceappdetector.mapper;

import com.example.faceappdetector.dto.EyeLeftTop;
import com.example.faceappdetector.entity.EyeLeftTopEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EyeLeftTopMapper {

    EyeLeftTop toDto(EyeLeftTopEntity entity);

    EyeLeftTopEntity toEntity(EyeLeftTop dto);
}
