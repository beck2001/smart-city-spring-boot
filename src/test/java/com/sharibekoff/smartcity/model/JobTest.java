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

public class JobTest {

    private Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void validJob() {
        Job job = new Job(1L, "job #1", 100_000d, "description #1");
        Set<ConstraintViolation<Job>> cv = validator.validate(job);
        assertTrue(cv.isEmpty());
    }

    @Test
    public void negativeSalaryTest() {
        Job job = new Job(1L, "job #1", -100_000d, "description #1");
        Set<ConstraintViolation<Job>> cv = validator.validate(job);
        assertEquals(1, cv.size());
    }
}
