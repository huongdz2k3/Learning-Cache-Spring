package com.example.LearningCache.controller;

import com.example.LearningCache.dto.DistrictsDto;
import com.example.LearningCache.model.Districts;
import com.example.LearningCache.service.DistrictsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/districts")
public class DistrictsController {

    private final DistrictsService districtsService;

    public DistrictsController(DistrictsService districtsService) {
        this.districtsService = districtsService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<DistrictsDto>> getAllDistricts() {
        return ResponseEntity.ok(districtsService.getAllDistricts());
    }

    @GetMapping("/units/{id}")
    public ResponseEntity<List<DistrictsDto>> getAllDistrictsByUnitsId(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok(districtsService.getAllDistrictsByUnitsId(id));
    }

    @GetMapping("/provinces/{code}")
    public ResponseEntity<List<DistrictsDto>> getAllDistrictsByProvincesCode(@PathVariable(name = "code") String provincesCode) {
        return ResponseEntity.ok(districtsService.getAllDistrictsByProvincesCode(provincesCode));
    }
}
