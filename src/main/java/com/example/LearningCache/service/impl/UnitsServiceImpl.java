package com.example.LearningCache.service.impl;

import com.example.LearningCache.dto.UnitsDto;
import com.example.LearningCache.mapper.UnitsMapper;
import com.example.LearningCache.model.Units;
import com.example.LearningCache.repository.UnitsRepository;
import com.example.LearningCache.service.UnitsService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UnitsServiceImpl implements UnitsService {
    private final UnitsRepository unitsRepository;

    public UnitsServiceImpl(UnitsRepository unitsRepository) {
        this.unitsRepository = unitsRepository;
    }

    @Override
    @Cacheable(value = "units")
    public List<UnitsDto> getAllUnits() {
        return convertToDto(unitsRepository.findAll());
    }

    private List<UnitsDto> convertToDto(List<Units> units) {
        return units.stream().map(unit -> UnitsMapper.INSTANCE.toDto(unit)).collect(Collectors.toList());
    }
}
