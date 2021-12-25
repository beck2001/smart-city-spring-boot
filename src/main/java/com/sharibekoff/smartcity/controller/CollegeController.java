package com.sharibekoff.smartcity.controller;

import com.sharibekoff.smartcity.model.College;
import com.sharibekoff.smartcity.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/college")
public class CollegeController {

    @Autowired
    private CollegeService collegeService;

    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    public List<College> getAll() {
        return collegeService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    public College getById(@PathVariable Long id) {
        return collegeService.getById(id);
    }
}
