package com.example.LearningCache.repository;

import com.example.LearningCache.model.Districts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface DistrictsRepository extends JpaRepository<Districts, String> {

    @Query("SELECT d FROM Districts d WHERE " +
            "d.name_en LIKE CONCAT('%', :query, '%')" +
            "OR d.code LIKE CONCAT('%', :query, '%')" +
            "OR d.code_name LIKE CONCAT('%', :query, '%')"
    )
    Page<Districts> searchDistricts(String query, Pageable pageable);

    Page<Districts> findAllByUnitsId(Integer id , Pageable pageable);
    Page<Districts> findAllByProvincesCode(String provincesCode , Pageable pageable);

}

