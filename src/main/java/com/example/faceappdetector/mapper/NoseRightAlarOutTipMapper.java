package com.example.faceappdetector.mapper;

import com.example.faceappdetector.dto.NoseRightAlarOutTip;
import com.example.faceappdetector.entity.NoseRightAlarOutTipEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NoseRightAlarOutTipMapper {

    NoseRightAlarOutTip toDto(NoseRightAlarOutTipEntity entity);

    NoseRightAlarOutTipEntity toEntity(NoseRightAlarOutTip dto);
}
