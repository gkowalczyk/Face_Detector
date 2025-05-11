package com.example.faceappdetector.mapper;

import com.example.faceappdetector.dto.NoseLeftAlarTop;
import com.example.faceappdetector.entity.NoseLeftAlarTopEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NoseLeftAlarTopMapper {

    NoseLeftAlarTop toDto(NoseLeftAlarTopEntity entity);

    NoseLeftAlarTopEntity toEntity(NoseLeftAlarTop dto);
}
