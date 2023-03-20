package com.example.LearningCache.service;

import com.example.LearningCache.dto.DistrictsDto;
import com.example.LearningCache.dto.list.ListDistrictsDto;

import java.util.List;

public interface DistrictsService {
    public ListDistrictsDto getDistricts(int pageNo , int pageSize, String query);

    public ListDistrictsDto getAllDistrictsByUnitsId(Integer id, int pageNo , int pageSize);

    public ListDistrictsDto getAllDistrictsByProvincesCode(String provincesCode, int pageNo , int pageSize);

    public DistrictsDto updateDistricts(DistrictsDto districtsDto, String id);

    public DistrictsDto addDistricts(DistrictsDto districtsDto);

    public String deleteDistricts(String id);

    public DistrictsDto getDistrictsById(String id);



}
