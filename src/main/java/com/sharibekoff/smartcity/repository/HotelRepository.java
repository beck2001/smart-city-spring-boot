package com.sharibekoff.smartcity.repository;

import com.sharibekoff.smartcity.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
