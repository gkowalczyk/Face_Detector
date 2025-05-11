package com.example.faceappdetector.mapper;

import com.example.faceappdetector.dto.PupilRight;
import com.example.faceappdetector.entity.PupilRightEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PupilRightMapper {

    PupilRight toDto(PupilRightEntity entity);

    PupilRightEntity toEntity(PupilRight dto);
}
