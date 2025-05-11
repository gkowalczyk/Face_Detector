package com.example.faceappdetector.mapper;

import com.example.faceappdetector.dto.PupilLeft;
import com.example.faceappdetector.entity.PupilLeftEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PupilLeftMapper {

    PupilLeft toDto(PupilLeftEntity entity);

    PupilLeftEntity toEntity(PupilLeft dto);
}
