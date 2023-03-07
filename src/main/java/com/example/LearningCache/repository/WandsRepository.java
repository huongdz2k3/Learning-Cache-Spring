package com.example.LearningCache.repository;

import com.example.LearningCache.model.Wands;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WandsRepository extends JpaRepository<Wands, String> {
    List<Wands> findAllByDistrictsCode(String code);

    List<Wands> findAllByUnitsId(Integer id);
}

