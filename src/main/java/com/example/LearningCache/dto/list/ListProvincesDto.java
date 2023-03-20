package com.example.LearningCache.dto.list;

import com.example.LearningCache.dto.ListData;
import com.example.LearningCache.dto.ProvincesDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListProvincesDto extends ListData implements Serializable {
    private List<ProvincesDto> data;
}
