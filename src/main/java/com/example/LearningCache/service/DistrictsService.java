package com.example.LearningCache.service;

import com.example.LearningCache.dto.DistrictsDto;

import java.util.List;

public interface DistrictsService {
    public List<DistrictsDto> getAllDistricts();

    public List<DistrictsDto> getAllDistrictsByUnitsId(Integer id);

    public List<DistrictsDto> getAllDistrictsByProvincesCode(String provincesCode);


}
