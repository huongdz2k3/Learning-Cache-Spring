package com.example.LearningCache.repository;

import com.example.LearningCache.model.Provinces;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProvincesRepository extends JpaRepository<Provinces, String> {

    List<Provinces> findAllByUnitsId(Integer id);
    List<Provinces> findAllByRegionsId(Integer id);
}

