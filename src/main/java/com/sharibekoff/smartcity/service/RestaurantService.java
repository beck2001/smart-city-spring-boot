package com.sharibekoff.smartcity.service;

import com.sharibekoff.smartcity.model.Restaurant;
import com.sharibekoff.smartcity.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Transactional
    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    @Transactional
    public Restaurant getById(Long id) {
        return restaurantRepository.findById(id)
                .orElse(new Restaurant());
    }
}
