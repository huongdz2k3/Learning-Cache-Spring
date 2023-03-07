package com.example.LearningCache.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UnitsDto implements Serializable {
    private int id;
    private String full_name;
    private String full_name_en;
    private String short_name;
    private String short_name_en;
    private String code_name;
    private String code_name_en;

    private List<DistrictsDto> districts;
    private List<WandsDto> wands;
    private List<ProvincesDto> provinces;

}