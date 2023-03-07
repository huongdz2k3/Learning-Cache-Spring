package com.example.LearningCache.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "administrative_units")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Units {
    @Id
    private Long  id;
    private String full_name;
    private String full_name_en;
    private String short_name;
    private String short_name_en;
    private String code_name;
    private String code_name_en;

    @OneToMany(mappedBy = "units", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Districts> districts;

    @OneToMany(mappedBy = "units", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Wands> wands;

    @OneToMany(mappedBy = "units", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Provinces> provinces;

}