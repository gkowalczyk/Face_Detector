package com.example.faceappdetector.mapper;

import com.example.faceappdetector.dto.UnderLipBottom;
import com.example.faceappdetector.entity.UnderLipBottomEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UnderLipBottomMapper {

    UnderLipBottom toDto(UnderLipBottomEntity entity);

    UnderLipBottomEntity toEntity(UnderLipBottom dto);
}
