package com.example.LearningCache.service;


import com.example.LearningCache.dto.ProvincesDto;

import java.util.List;

public interface ProvincesService {
    public List<ProvincesDto> getAllProvinces();

    public List<ProvincesDto> getAllProvincesByUnitsId(Integer id);

    public List<ProvincesDto> getAllProvincesByRegionsId(Integer id);


}
