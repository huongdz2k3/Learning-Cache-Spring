package com.example.LearningCache.controller;

import com.example.LearningCache.dto.WandsDto;
import com.example.LearningCache.service.WandsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/wands")
public class WandsController {

    private final WandsService wandsService;

    public WandsController(WandsService wandsService) {
        this.wandsService = wandsService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<WandsDto>> getAllWands() {
        return ResponseEntity.ok(wandsService.getAllWands());
    }

    @GetMapping("units/{id}")
    public ResponseEntity<List<WandsDto>> getAllWandsByUnitsId(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(wandsService.getWandsByUnitId(id));
    }

    @GetMapping("districts/{code}")
    public ResponseEntity<List<WandsDto>> getAllWandsByDistrictsCode(@PathVariable("code") String code) {
        return ResponseEntity.ok(wandsService.getWandsByDistrictCode(code));
    }


}
