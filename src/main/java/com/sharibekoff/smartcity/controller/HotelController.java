package com.sharibekoff.smartcity.controller;

import com.sharibekoff.smartcity.model.Hotel;
import com.sharibekoff.smartcity.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TOURIST')")
    public List<Hotel> getAll() {
        return hotelService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TOURIST')")
    public Hotel getById(@PathVariable Long id) {
        return hotelService.findById(id);
    }
}
