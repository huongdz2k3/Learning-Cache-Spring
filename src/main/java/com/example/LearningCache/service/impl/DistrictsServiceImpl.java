package com.example.LearningCache.service.impl;

import com.example.LearningCache.dto.DistrictsDto;
import com.example.LearningCache.dto.list.ListDistrictsDto;
import com.example.LearningCache.mapper.DistrictsMapper;
import com.example.LearningCache.model.Districts;
import com.example.LearningCache.repository.DistrictsRepository;
import com.example.LearningCache.service.DistrictsService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DistrictsServiceImpl implements DistrictsService {

    private final DistrictsRepository districtsRepository;

    public DistrictsServiceImpl(DistrictsRepository districtsRepository) {
        this.districtsRepository = districtsRepository;
    }

    @CacheEvict(value="districts", allEntries=true)
    @Override
    public ListDistrictsDto getDistricts(int pageNo, int pageSize,String query) {
        Pageable pageable = Pageable.ofSize(pageSize).withPage(pageNo);
        Page<Districts> districts = districtsRepository.searchDistricts(query,pageable);

        var districtsDto = new ListDistrictsDto();

        districtsDto.setData(districts.stream().map(DistrictsMapper.INSTANCE::toDto).collect(Collectors.toList()));
        districtsDto.setPageNo(districts.getNumber());
        districtsDto.setPageSize(districts.getSize());
        districtsDto.setTotalPages(districts.getTotalPages());
        districtsDto.setLast(districts.isLast());
        districtsDto.setTotalElements(districts.getTotalElements());

        return districtsDto ;
    }
    @Cacheable(value = "districts-unit-id")
    @Override
    public ListDistrictsDto getAllDistrictsByUnitsId(Integer id, int pageNo, int pageSize) {
        Pageable pageable = Pageable.ofSize(pageSize).withPage(pageNo);
        Page<Districts> districts = districtsRepository.findAllByUnitsId(id, pageable);

        var districtsDto = new ListDistrictsDto();

        districtsDto.setData(districts.stream().map(DistrictsMapper.INSTANCE::toDto).collect(Collectors.toList()));
        districtsDto.setPageNo(districts.getNumber());
        districtsDto.setPageSize(districts.getSize());
        districtsDto.setTotalPages(districts.getTotalPages());
        districtsDto.setLast(districts.isLast());
        districtsDto.setTotalElements(districts.getTotalElements());

        return districtsDto ;
    }
    @Cacheable(value = "districts-by-provinces-code")
    @Override
    public ListDistrictsDto getAllDistrictsByProvincesCode(String provincesCode, int pageNo, int pageSize) {
        Pageable pageable = Pageable.ofSize(pageSize).withPage(pageNo);
        Page<Districts> districts = districtsRepository.findAllByProvincesCode(provincesCode, pageable);

        var districtsDto = new ListDistrictsDto();

        districtsDto.setData(districts.stream().map(DistrictsMapper.INSTANCE::toDto).collect(Collectors.toList()));
        districtsDto.setPageNo(districts.getNumber());
        districtsDto.setPageSize(districts.getSize());
        districtsDto.setTotalPages(districts.getTotalPages());
        districtsDto.setLast(districts.isLast());
        districtsDto.setTotalElements(districts.getTotalElements());

        return districtsDto ;
    }

    @Override
    public DistrictsDto updateDistricts(DistrictsDto districtsDto, String id) {
        Districts districts = districtsRepository.findById(id).orElse(null);
        if (districts == null) {
            throw new RuntimeException("Districts not found");
        }
        districts.setCode(districtsDto.getCode());
        districts.setName(districtsDto.getName());
        districts.setFull_name(districtsDto.getFull_name());
        districts.setCode(districtsDto.getCode());
        districts.setCode_name(districtsDto.getCode_name());
        districts.setFull_name_en(districtsDto.getFull_name_en());
        districtsRepository.save(districts);
        return DistrictsMapper.INSTANCE.toDto(districts);
    }

    @Override
    public DistrictsDto addDistricts(DistrictsDto districtsDto) {
        Districts districts = DistrictsMapper.INSTANCE.toEntity(districtsDto);
        districtsRepository.save(districts);
        return DistrictsMapper.INSTANCE.toDto(districts);
    }

    @Override
    public String deleteDistricts(String id) {
        Districts districts = districtsRepository.findById(id).orElse(null);
        if (districts == null) {
            throw new RuntimeException("Districts not found");
        }
        districtsRepository.delete(districts);
        return "Districts deleted";
    }

    @Override
    public DistrictsDto getDistrictsById(String id) {
        Districts districts = districtsRepository.findById(id).orElse(null);
        if (districts == null) {
            throw new RuntimeException("Districts not found");
        }
        return DistrictsMapper.INSTANCE.toDto(districts);
    }
}
