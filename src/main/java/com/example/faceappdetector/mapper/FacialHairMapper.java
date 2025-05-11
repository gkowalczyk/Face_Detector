package com.example.faceappdetector.mapper;

import com.example.faceappdetector.dto.FacialHair;
import com.example.faceappdetector.entity.FacialHairEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FacialHairMapper {

    FacialHair toDto(FacialHairEntity entity);

    FacialHairEntity toEntity(FacialHair dto);
}
