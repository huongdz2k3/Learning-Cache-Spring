package com.example.LearningCache.dto.list;

import com.example.LearningCache.dto.ListData;
import com.example.LearningCache.dto.WandsDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListWandsDto extends ListData implements Serializable {
    private List<WandsDto> data;
}
