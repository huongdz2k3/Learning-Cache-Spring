package com.example.LearningCache.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="districts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Districts {
    @Id
    private String code;
    private String name;
    private String name_en;
    private String full_name;
    private String full_name_en;
    private String code_name;
    @OneToMany(mappedBy = "districts", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Wands> wands;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "province_code")
    private Provinces provinces;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "administrative_unit_id")
    private Units units;


}
