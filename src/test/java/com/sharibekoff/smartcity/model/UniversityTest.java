package com.sharibekoff.smartcity.model;

import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDate;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UniversityTest {

    private Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void validUniversity() {
        University university = new University(1L, "university #1", "address #1", 10_000,
                LocalDate.of(2021, 12, 25));
        Set<ConstraintViolation<University>> cv = validator.validate(university);
        assertTrue(cv.isEmpty());
    }

    @Test
    public void wrongNumberOfStudents() {
        University university = new University(1L, "university #1", "address #1", -10_000,
                LocalDate.of(2021, 12, 25));
        Set<ConstraintViolation<University>> cv = validator.validate(university);
        assertEquals(1, cv.size());
    }
}
