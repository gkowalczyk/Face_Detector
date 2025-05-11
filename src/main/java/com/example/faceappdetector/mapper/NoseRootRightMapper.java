package com.example.faceappdetector.mapper;

import com.example.faceappdetector.dto.NoseRootRight;
import com.example.faceappdetector.entity.NoseRootRightEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NoseRootRightMapper {

    NoseRootRight toDto(NoseRootRightEntity entity);

    NoseRootRightEntity toEntity(NoseRootRight dto);
}
