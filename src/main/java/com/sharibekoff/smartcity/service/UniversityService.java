package com.sharibekoff.smartcity.service;

import com.sharibekoff.smartcity.model.University;
import com.sharibekoff.smartcity.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UniversityService {

    @Autowired
    private UniversityRepository universityRepository;

    @Transactional
    public List<University> getAll() {
        return universityRepository.findAll();
    }

    @Transactional
    public University getById(Long id) {
        return universityRepository.findById(id)
                .orElse(new University());
    }
}
