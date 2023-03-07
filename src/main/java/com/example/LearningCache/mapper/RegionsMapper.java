package com.example.LearningCache.mapper;

import com.example.LearningCache.dto.RegionsDto;
import com.example.LearningCache.model.Regions;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RegionsMapper {
    RegionsMapper INSTANCE = Mappers.getMapper(RegionsMapper.class);

    RegionsDto toDto(Regions entity);

    Regions toEntity(RegionsDto dto);
}
