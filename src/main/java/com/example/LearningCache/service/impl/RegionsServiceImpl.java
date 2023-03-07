package com.example.LearningCache.service.impl;

import com.example.LearningCache.dto.RegionsDto;
import com.example.LearningCache.model.Regions;
import com.example.LearningCache.repository.RegionsRepository;
import com.example.LearningCache.service.RegionsService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionsServiceImpl implements RegionsService {
    private final RegionsRepository regionsRepository;

    public RegionsServiceImpl(RegionsRepository regionsRepository) {
        this.regionsRepository = regionsRepository;
    }

    @Override
    @Cacheable(value = "regions")
    public List<RegionsDto> getAllRegions() {
        return null;
    }
}
