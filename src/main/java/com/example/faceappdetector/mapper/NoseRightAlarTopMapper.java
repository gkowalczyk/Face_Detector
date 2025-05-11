package com.example.faceappdetector.mapper;

import com.example.faceappdetector.dto.NoseRightAlarTop;
import com.example.faceappdetector.entity.NoseRightAlarTopEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NoseRightAlarTopMapper {

    NoseRightAlarTop toDto(NoseRightAlarTopEntity entity);

    NoseRightAlarTopEntity toEntity(NoseRightAlarTop dto);
}
