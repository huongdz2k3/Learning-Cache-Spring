package com.example.LearningCache.dto.list;

import com.example.LearningCache.dto.DistrictsDto;
import com.example.LearningCache.dto.ListData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListDistrictsDto extends ListData implements Serializable {
    private List<DistrictsDto> data;
}
