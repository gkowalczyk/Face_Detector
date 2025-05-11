package com.example.faceappdetector.mapper;

import com.example.faceappdetector.dto.EyeLeftBottom;
import com.example.faceappdetector.entity.EyeLeftBottomEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EyeLeftBottomMapper {

    EyeLeftBottom toDto(EyeLeftBottomEntity entity);

    EyeLeftBottomEntity toEntity(EyeLeftBottom dto);
}
