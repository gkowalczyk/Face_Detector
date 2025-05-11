package com.example.faceappdetector.mapper;

import com.example.faceappdetector.dto.Hair;
import com.example.faceappdetector.entity.HairEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HairMapper {

    Hair toDto(HairEntity entity);

    HairEntity toEntity(Hair dto);
}
