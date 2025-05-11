package com.example.faceappdetector.mapper;

import com.example.faceappdetector.dto.UnderLipTop;
import com.example.faceappdetector.entity.UnderLipTopEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UnderLipTopMapper {

    UnderLipTop toDto(UnderLipTopEntity entity);

    UnderLipTopEntity toEntity(UnderLipTop dto);
}
