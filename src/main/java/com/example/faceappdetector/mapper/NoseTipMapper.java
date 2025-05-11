package com.example.faceappdetector.mapper;

import com.example.faceappdetector.dto.NoseTip;
import com.example.faceappdetector.entity.NoseTipEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NoseTipMapper {

    NoseTip toDto(NoseTipEntity entity);

    NoseTipEntity toEntity(NoseTip dto);
}
