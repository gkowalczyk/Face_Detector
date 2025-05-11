package com.example.faceappdetector.mapper;

import com.example.faceappdetector.dto.UpperLipTop;
import com.example.faceappdetector.entity.UpperLipTopEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UpperLipTopMapper {

    UpperLipTop toDto(UpperLipTopEntity entity);

    UpperLipTopEntity toEntity(UpperLipTop dto);
}
