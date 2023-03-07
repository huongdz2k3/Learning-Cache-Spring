package com.example.LearningCache.mapper;

import com.example.LearningCache.dto.DistrictsDto;
import com.example.LearningCache.model.Districts;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DistrictsMapper {
    DistrictsMapper INSTANCE = Mappers.getMapper(DistrictsMapper.class);
    DistrictsDto toDto(Districts entity);

    Districts toEntity(DistrictsDto dto);
}
