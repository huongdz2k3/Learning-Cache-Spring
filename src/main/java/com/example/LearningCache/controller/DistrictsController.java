package com.example.LearningCache.controller;

import com.example.LearningCache.constants.AppConstants;
import com.example.LearningCache.dto.DistrictsDto;
import com.example.LearningCache.dto.list.ListDistrictsDto;
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
    public ResponseEntity<ListDistrictsDto> getAllDistricts(
            @RequestParam(value = "pageNo" , defaultValue = AppConstants.DEFAULT_PAGE_NUMBER , required = false) int pageNo,
            @RequestParam(value = "pageSize" , defaultValue = AppConstants.DEFAULT_PAGE_SIZE , required = false) int pageSize,
            @RequestParam(value = "query" , defaultValue = "" , required = false) String query
    ) {
        System.out.println("pageNo = " + pageNo + "  " + "pageSize = " + pageSize);
        ListDistrictsDto allDistricts = districtsService.getDistricts(pageNo, pageSize,query);
        return ResponseEntity.ok(allDistricts);
    }

    @GetMapping("/units/{id}")
    public ResponseEntity<ListDistrictsDto> getAllDistrictsByUnitsId(
            @PathVariable(name = "id") Integer id,
            @RequestParam(value = "pageNo" , defaultValue = AppConstants.DEFAULT_PAGE_NUMBER , required = false) int pageNo,
            @RequestParam(value = "pageSize" , defaultValue = AppConstants.DEFAULT_PAGE_SIZE , required = false) int pageSize
            ) {
        System.out.println("pageNo = " + pageNo + "  " + "pageSize = " + pageSize);

        return ResponseEntity.ok(districtsService.getAllDistrictsByUnitsId(id,pageNo,pageSize));
    }

    @GetMapping("/provinces/{code}")
    public ResponseEntity<ListDistrictsDto> getAllDistrictsByProvincesCode(
            @PathVariable(name = "code") String provincesCode,
            @RequestParam(value = "pageNo" , defaultValue = AppConstants.DEFAULT_PAGE_NUMBER , required = false) int pageNo,
            @RequestParam(value = "pageSize" , defaultValue = AppConstants.DEFAULT_PAGE_SIZE , required = false) int pageSize) {
        System.out.println("pageNo = " + pageNo + "  " + "pageSize = " + pageSize);

        return ResponseEntity.ok(districtsService.getAllDistrictsByProvincesCode(provincesCode,pageNo,pageSize));
    }

    @PostMapping()
    public ResponseEntity<DistrictsDto> addDistricts(@RequestBody DistrictsDto districtsDto){
        return ResponseEntity.ok(districtsService.addDistricts(districtsDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DistrictsDto> updateDistricts(@RequestBody DistrictsDto districtsDto, @PathVariable("id") String id){
        return ResponseEntity.ok(districtsService.updateDistricts(districtsDto,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDistricts(@PathVariable("id") String id){
        return ResponseEntity.ok(districtsService.deleteDistricts(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DistrictsDto> getDistrictsById(@PathVariable("id") String id){
        return ResponseEntity.ok(districtsService.getDistrictsById(id));
    }


}
