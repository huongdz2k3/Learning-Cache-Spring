package com.example.LearningCache.controller;

import com.example.LearningCache.dto.ProvincesDto;
import com.example.LearningCache.service.ProvincesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/provinces")
public class ProvincesController {
    private final ProvincesService provincesService;

    public ProvincesController(ProvincesService provincesService) {
        this.provincesService = provincesService;
    }
    @GetMapping("all")
    public ResponseEntity<List<ProvincesDto>> getAllProvinces(){
        return ResponseEntity.ok(provincesService.getAllProvinces());
    }

    @GetMapping("/units/{id}")
    public ResponseEntity<List<ProvincesDto>> getAllProvincesByUnitsId(@PathVariable("id") Integer id){
        return ResponseEntity.ok(provincesService.getAllProvincesByUnitsId(id));
    }

    @GetMapping("/regions/{id}")
    public ResponseEntity<List<ProvincesDto>> getAllProvincesByRegionsId(@PathVariable("id") Integer id){
        return ResponseEntity.ok(provincesService.getAllProvincesByRegionsId(id));
    }
}
