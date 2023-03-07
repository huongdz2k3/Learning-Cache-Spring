package com.example.LearningCache.mapper;

import com.example.LearningCache.dto.ProvincesDto;
import com.example.LearningCache.model.Provinces;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProvincesMapper {
    ProvincesMapper INSTANCE = Mappers.getMapper(ProvincesMapper.class);

    ProvincesDto toDto(Provinces entity);

    Provinces toEntity(ProvincesDto dto);
}
