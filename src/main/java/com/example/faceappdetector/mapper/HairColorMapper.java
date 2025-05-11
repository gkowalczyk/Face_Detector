package com.example.faceappdetector.mapper;

import com.example.faceappdetector.dto.HairColor;
import com.example.faceappdetector.entity.HairColorEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HairColorMapper {

    HairColor toDto(HairColorEntity entity);

    HairColorEntity toEntity(HairColor dto);
}
