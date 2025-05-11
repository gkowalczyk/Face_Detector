package com.example.faceappdetector.mapper;


import com.example.faceappdetector.dto.Gender;
import com.example.faceappdetector.entity.GenderEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GenderMapper {
    Gender toDto(GenderEntity entity);

    GenderEntity toEntity(Gender dto);
}
