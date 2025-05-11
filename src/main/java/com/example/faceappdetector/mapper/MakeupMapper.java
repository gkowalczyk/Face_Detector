package com.example.faceappdetector.mapper;

import com.example.faceappdetector.dto.Makeup;
import com.example.faceappdetector.entity.MakeupEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MakeupMapper {

    Makeup toDto(MakeupEntity entity);

    MakeupEntity toEntity(Makeup dto);
}
