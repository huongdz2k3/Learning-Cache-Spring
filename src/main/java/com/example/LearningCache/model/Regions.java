package com.example.LearningCache.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="administrative_regions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Regions {
    @Id
    private Long id;
    private String name;
    private String name_en;
    private String code_name;
    private String code_name_en;

    @OneToMany(mappedBy = "regions", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Provinces> provinces;

}
