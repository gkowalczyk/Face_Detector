package com.example.faceappdetector.mapper;

import com.example.faceappdetector.dto.EyebrowRightInner;
import com.example.faceappdetector.entity.EyebrowRightInnerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EyebrowRightInnerMapper {

    EyebrowRightInner toDto(EyebrowRightInnerEntity entity);

    EyebrowRightInnerEntity toEntity(EyebrowRightInner dto);
}
