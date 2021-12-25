package com.sharibekoff.smartcity.controller;

import com.sharibekoff.smartcity.model.University;
import com.sharibekoff.smartcity.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/university")
public class UniversityController {

    @Autowired
    private UniversityService universityService;

    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    public List<University> getAll() {
        return universityService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    public University getById(@PathVariable Long id) {
        return universityService.getById(id);
    }
}
