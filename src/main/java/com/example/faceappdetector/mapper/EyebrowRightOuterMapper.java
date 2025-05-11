package com.example.faceappdetector.mapper;

import com.example.faceappdetector.dto.EyebrowRightOuter;
import com.example.faceappdetector.entity.EyebrowRightOuterEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EyebrowRightOuterMapper {

    EyebrowRightOuter toDto(EyebrowRightOuterEntity entity);

    EyebrowRightOuterEntity toEntity(EyebrowRightOuter dto);
}
