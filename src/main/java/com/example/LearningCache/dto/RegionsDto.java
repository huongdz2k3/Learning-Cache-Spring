package com.example.LearningCache.dto;

import lombok.*;


import java.io.Serializable;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegionsDto implements Serializable {
    private int id;
    private String name;
    private String name_en;
    private String code_name;
    private String code_name_en;

    private List<ProvincesDto> provinces;


}