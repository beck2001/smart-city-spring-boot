package com.sharibekoff.smartcity.repository;

import com.sharibekoff.smartcity.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
