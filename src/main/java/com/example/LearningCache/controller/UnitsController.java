package com.example.LearningCache.controller;

import com.example.LearningCache.dto.UnitsDto;
import com.example.LearningCache.service.UnitsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/units")
public class UnitsController {

    private final UnitsService unitsService;

    public UnitsController(UnitsService unitsService) {
        this.unitsService = unitsService;
    }

    @RequestMapping("/all")
    public ResponseEntity<List<UnitsDto>> getAllUnits() {
        return ResponseEntity.ok(unitsService.getAllUnits());
    }
}
