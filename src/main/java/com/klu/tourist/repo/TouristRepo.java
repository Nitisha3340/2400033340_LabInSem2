package com.klu.tourist.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.klu.tourist.entity.Tourist;

public interface TouristRepo
        extends JpaRepository<Tourist, Long> {

}