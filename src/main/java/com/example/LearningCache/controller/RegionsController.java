package com.example.LearningCache.controller;

import com.example.LearningCache.dto.RegionsDto;
import com.example.LearningCache.model.Regions;
import com.example.LearningCache.service.RegionsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/regions")
public class RegionsController {
    private final RegionsService regionsService;

    public RegionsController(RegionsService regionsService) {
        this.regionsService = regionsService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<RegionsDto>> getAllRegions() {
        return ResponseEntity.ok(regionsService.getAllRegions());
    }
}
