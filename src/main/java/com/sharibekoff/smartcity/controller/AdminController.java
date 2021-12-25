package com.sharibekoff.smartcity.controller;

import com.sharibekoff.smartcity.model.College;
import com.sharibekoff.smartcity.model.Hotel;
import com.sharibekoff.smartcity.service.CollegeService;
import com.sharibekoff.smartcity.service.HotelService;
import com.sharibekoff.smartcity.service.RestaurantService;
import com.sharibekoff.smartcity.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private CollegeService collegeService;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private UniversityService universityService;

    @GetMapping("/college/all")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<College> findAllColleges() {
        return collegeService.getAll();
    }

    @GetMapping("/college/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public College getCollegeById(@PathVariable Long id) {
        return collegeService.getById(id);
    }

    @PostMapping("/college")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public College newCollege(@RequestBody College newCollege) {
        return collegeService.createCollege(newCollege);
    }

    @DeleteMapping("/college/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteCollege(@PathVariable Long id) {
        collegeService.remove(collegeService.getById(id));
    }

    @GetMapping("/hotel/all")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Hotel> findAllHotels() {
        return hotelService.findAll();
    }

    @GetMapping("/hotel/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Hotel getHotelById(@PathVariable Long id) {
        return hotelService.findById(id);
    }

    @DeleteMapping("/hotel/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteHotel(@PathVariable Long id) {
        hotelService.delete(hotelService.findById(id));
    }
}
