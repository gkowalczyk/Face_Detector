package com.example.faceappdetector.mapper;

import com.example.faceappdetector.dto.UpperLipBottom;
import com.example.faceappdetector.entity.UpperLipBottomEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UpperLipBottomMapper {

    UpperLipBottom toDto(UpperLipBottomEntity entity);

    UpperLipBottomEntity toEntity(UpperLipBottom dto);
}
