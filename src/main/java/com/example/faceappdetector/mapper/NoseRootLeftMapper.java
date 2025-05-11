package com.example.faceappdetector.mapper;

import com.example.faceappdetector.dto.NoseRootLeft;
import com.example.faceappdetector.entity.NoseRootLeftEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NoseRootLeftMapper {

    NoseRootLeft toDto(NoseRootLeftEntity entity);

    NoseRootLeftEntity toEntity(NoseRootLeft dto);
}
