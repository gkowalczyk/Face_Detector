package com.example.faceappdetector.mapper;

import com.example.faceappdetector.dto.Beauty;
import com.example.faceappdetector.entity.BeautyEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BeautyMapper {
    Beauty toDto(BeautyEntity entity);
    BeautyEntity toEntity(Beauty dto);
}
