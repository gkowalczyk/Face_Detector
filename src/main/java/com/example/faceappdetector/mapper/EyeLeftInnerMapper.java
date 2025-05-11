package com.example.faceappdetector.mapper;

import com.example.faceappdetector.dto.EyeLeftInner;
import com.example.faceappdetector.entity.EyeLeftInnerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EyeLeftInnerMapper {

    EyeLeftInner toDto(EyeLeftInnerEntity entity);

    EyeLeftInnerEntity toEntity(EyeLeftInner dto);
}
