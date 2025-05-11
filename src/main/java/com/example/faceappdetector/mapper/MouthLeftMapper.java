package com.example.faceappdetector.mapper;

import com.example.faceappdetector.dto.MouthLeft;
import com.example.faceappdetector.entity.MouthLeftEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MouthLeftMapper {

    MouthLeft toDto(MouthLeftEntity entity);

    MouthLeftEntity toEntity(MouthLeft dto);
}
