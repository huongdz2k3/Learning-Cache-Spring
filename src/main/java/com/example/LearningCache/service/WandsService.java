package com.example.LearningCache.service;

import com.example.LearningCache.dto.WandsDto;

import java.util.List;

public interface WandsService {
    public List<WandsDto> getAllWands();

    public List<WandsDto> getWandsByUnitId(Integer unitId);

    public List<WandsDto> getWandsByDistrictCode(String code);

}
