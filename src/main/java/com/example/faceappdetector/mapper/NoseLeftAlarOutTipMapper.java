package com.example.faceappdetector.mapper;

import com.example.faceappdetector.dto.NoseLeftAlarOutTip;
import com.example.faceappdetector.entity.NoseLeftAlarOutTipEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NoseLeftAlarOutTipMapper {

    NoseLeftAlarOutTip toDto(NoseLeftAlarOutTipEntity entity);

    NoseLeftAlarOutTipEntity toEntity(NoseLeftAlarOutTip dto);
}
