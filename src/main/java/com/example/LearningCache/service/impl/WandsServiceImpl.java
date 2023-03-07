package com.example.LearningCache.service.impl;

import com.example.LearningCache.dto.WandsDto;
import com.example.LearningCache.mapper.WandsMapper;
import com.example.LearningCache.model.Wands;
import com.example.LearningCache.repository.WandsRepository;
import com.example.LearningCache.service.WandsService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WandsServiceImpl implements WandsService {
    private final WandsRepository wandsRepository;

    public WandsServiceImpl(WandsRepository wandsRepository) {
        this.wandsRepository = wandsRepository;
    }

    @Override
    public List<WandsDto> getAllWands() {
        return convertToDto(wandsRepository.findAll());
    }

    @Override
    @Cacheable(value = "wands")
    public List<WandsDto> getWandsByUnitId(Integer unitId) {
        List<Wands> wands = wandsRepository.findAllByUnitsId(unitId);
        return convertToDto(wands);
    }

    @Override
    @Cacheable(value = "wands")
    public List<WandsDto> getWandsByDistrictCode(String code) {
        return convertToDto(wandsRepository.findAllByDistrictsCode(code));
    }

    private List<WandsDto> convertToDto(List<Wands> wands) {
        return wands.stream().map(wand -> WandsMapper.INSTANCE.toDto(wand)).collect(Collectors.toList());
    }
}
