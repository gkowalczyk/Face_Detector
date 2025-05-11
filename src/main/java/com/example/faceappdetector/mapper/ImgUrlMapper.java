package com.example.faceappdetector.mapper;

import com.example.faceappdetector.dto.ImgUrl;
import com.example.faceappdetector.entity.ImgUrlEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImgUrlMapper {

    ImgUrl toDto(ImgUrlEntity entity);

    ImgUrlEntity toEntity(ImgUrl dto);
}
