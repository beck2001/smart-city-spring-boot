package com.sharibekoff.smartcity.controller;

import com.sharibekoff.smartcity.model.Restaurant;
import com.sharibekoff.smartcity.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TOURIST')")
    public List<Restaurant> getAll() {
        return restaurantService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TOURIST')")
    public Restaurant getById(@PathVariable Long id) {
        return restaurantService.getById(id);
    }

}
