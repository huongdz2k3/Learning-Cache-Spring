package com.example.LearningCache.mapper;

import com.example.LearningCache.dto.UnitsDto;
import com.example.LearningCache.model.Units;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UnitsMapper {
    UnitsMapper INSTANCE = Mappers.getMapper(UnitsMapper.class);

    Units toEntity(UnitsDto dto);

    UnitsDto toDto(Units entity);

}
