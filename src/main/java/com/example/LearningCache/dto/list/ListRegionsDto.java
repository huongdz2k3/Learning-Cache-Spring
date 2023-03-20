package com.example.LearningCache.dto.list;

import com.example.LearningCache.dto.ListData;
import com.example.LearningCache.dto.RegionsDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ListRegionsDto extends ListData implements Serializable {
    private List<RegionsDto> data;

}
