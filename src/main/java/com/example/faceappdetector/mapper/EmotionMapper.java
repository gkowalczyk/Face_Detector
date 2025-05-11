package com.example.faceappdetector.mapper;

import com.example.faceappdetector.dto.Emotion;
import com.example.faceappdetector.entity.EmotionEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmotionMapper {
    Emotion toDto(EmotionEntity entity);
    EmotionEntity toEntity(Emotion dto);
}