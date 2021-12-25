package com.sharibekoff.smartcity.repository;

import com.sharibekoff.smartcity.model.College;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeRepository extends JpaRepository<College, Long> {
    College findByName(String name);
}
