package com.sharibekoff.smartcity.service;

import com.sharibekoff.smartcity.model.College;
import com.sharibekoff.smartcity.repository.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CollegeService {

    @Autowired
    private CollegeRepository collegeRepository;

    @Transactional
    public List<College> getAll() {
        return collegeRepository.findAll();
    }

    @Transactional
    public College getById(Long id) {
        return collegeRepository.findById(id)
                .orElse(new College());
    }

    @Transactional
    public College createCollege(College college) {
        collegeRepository.save(college);
        return college;
    }

    @Transactional
    public College remove(College college) {
        collegeRepository.delete(college);
        return college;
    }
}
