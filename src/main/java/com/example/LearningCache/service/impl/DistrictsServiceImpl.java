package com.example.LearningCache.service.impl;

import com.example.LearningCache.dto.DistrictsDto;
import com.example.LearningCache.mapper.DistrictsMapper;
import com.example.LearningCache.model.Districts;
import com.example.LearningCache.repository.DistrictsRepository;
import com.example.LearningCache.service.DistrictsService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DistrictsServiceImpl implements DistrictsService {

    private final DistrictsRepository districtsRepository;

    public DistrictsServiceImpl(DistrictsRepository districtsRepository) {
        this.districtsRepository = districtsRepository;
    }

    @Override
    @Cacheable(value = "districts")
    public List<DistrictsDto> getAllDistricts() {
        List<Districts> districts = districtsRepository.findAll();

        return convertListDistrictsToDto(districts);
    }

    @Override
    @Cacheable(value = "districts")
    public List<DistrictsDto> getAllDistrictsByUnitsId(Integer id) {
        List<Districts> districts = districtsRepository.findAllByUnitsId(id);

        return convertListDistrictsToDto(districts);
    }

    @Override
    @Cacheable(value = "districts")
    public List<DistrictsDto> getAllDistrictsByProvincesCode(String provincesCode) {
        return convertListDistrictsToDto(districtsRepository.findAllByProvincesCode(provincesCode));
    }

    private List<DistrictsDto> convertListDistrictsToDto(List<Districts> districts) {
        return districts.stream().map(district -> DistrictsMapper.INSTANCE.toDto(district)).collect(Collectors.toList());
    }
}
