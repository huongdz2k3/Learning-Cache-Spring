package com.example.LearningCache.repository;

import com.example.LearningCache.model.Districts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface DistrictsRepository extends JpaRepository<Districts, String> {

    List<Districts> findAllByUnitsId(Integer id);
    List<Districts> findAllByProvincesCode(String provincesCode);

}

