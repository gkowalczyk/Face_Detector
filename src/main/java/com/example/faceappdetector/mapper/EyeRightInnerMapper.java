package com.example.faceappdetector.mapper;

import com.example.faceappdetector.dto.EyeRightInner;
import com.example.faceappdetector.entity.EyeRightInnerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EyeRightInnerMapper {

    EyeRightInner toDto(EyeRightInnerEntity entity);

    EyeRightInnerEntity toEntity(EyeRightInner dto);
}
