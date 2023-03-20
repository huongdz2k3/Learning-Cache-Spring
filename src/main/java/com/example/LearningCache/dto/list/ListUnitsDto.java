package com.example.LearningCache.dto.list;

import com.example.LearningCache.dto.ListData;
import com.example.LearningCache.dto.UnitsDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListUnitsDto extends ListData implements Serializable {
    private List<UnitsDto> data;
}
