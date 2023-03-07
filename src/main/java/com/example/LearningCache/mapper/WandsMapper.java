package com.example.LearningCache.mapper;

import com.example.LearningCache.dto.WandsDto;
import com.example.LearningCache.model.Wands;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WandsMapper {
    WandsMapper INSTANCE = Mappers.getMapper(WandsMapper.class);

    WandsDto toDto(Wands entity);

    Wands toEntity(WandsDto dto);
}
