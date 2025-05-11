package com.example.faceappdetector.mapper;

import com.example.faceappdetector.dto.EyeRightBottom;
import com.example.faceappdetector.entity.EyeRightBottomEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EyeRightBottomMapper {

    EyeRightBottom toDto(EyeRightBottomEntity entity);

    EyeRightBottomEntity toEntity(EyeRightBottom dto);
}
