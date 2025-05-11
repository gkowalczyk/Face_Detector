package com.example.faceappdetector.mapper;

import com.example.faceappdetector.dto.MouthRight;
import com.example.faceappdetector.entity.MouthRightEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MouthRightMapper {

    MouthRight toDto(MouthRightEntity entity);

    MouthRightEntity toEntity(MouthRight dto);
}
