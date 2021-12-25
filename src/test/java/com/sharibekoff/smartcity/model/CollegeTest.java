package com.sharibekoff.smartcity.model;

import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CollegeTest {

    private Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void validCollege() {
        College college = new College(1L, "college #1", "address #1", 10_000);
        Set<ConstraintViolation<College>> cv = validator.validate(college);
        assertTrue(cv.isEmpty());
    }

    @Test
    public void negativeNumberOfStudents() {
        College college = new College(1L, "college #1", "address #1", -3_000);
        Set<ConstraintViolation<College>> cv = validator.validate(college);
        assertEquals(1, cv.size());
    }

    @Test
    public void invalidCollegeName() {
        College college = new College(1L, "", "address #1", 10_000);
        Set<ConstraintViolation<College>> cv = validator.validate(college);
        assertEquals(1, cv.size());
    }

}
