package com.example.LearningCache.service.impl;

import com.example.LearningCache.dto.ProvincesDto;
import com.example.LearningCache.mapper.ProvincesMapper;
import com.example.LearningCache.model.Provinces;
import com.example.LearningCache.repository.ProvincesRepository;
import com.example.LearningCache.service.ProvincesService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProvincesServiceImpl implements ProvincesService{
    private final ProvincesRepository provincesRepository;

    public ProvincesServiceImpl(ProvincesRepository provincesRepository) {
        this.provincesRepository = provincesRepository;
    }

    @Override
    @Cacheable(value = "provinces")
    public List<ProvincesDto> getAllProvinces() {
        return convertToDto(provincesRepository.findAll());
    }

    @Override
    @Cacheable(value = "provinces")
    public List<ProvincesDto> getAllProvincesByUnitsId(Integer id) {
        return convertToDto(provincesRepository.findAllByUnitsId(id));
    }

    @Override
    @Cacheable(value = "provinces")
    public List<ProvincesDto> getAllProvincesByRegionsId(Integer id) {
        return convertToDto(provincesRepository.findAllByRegionsId(id));
    }

    private List<ProvincesDto> convertToDto(List<Provinces> provinces) {
        return provinces.stream().map(province -> ProvincesMapper.INSTANCE.toDto(province)).collect(Collectors.toList());
    }
}
