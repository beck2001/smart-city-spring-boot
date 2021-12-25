package com.sharibekoff.smartcity.model;

import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class HotelTest {

    private Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void validHotel() {
        Hotel hotel = new Hotel(1L, "hotel #1", "address #1", 12000d);
        Set<ConstraintViolation<Hotel>> cv = validator.validate(hotel);
        assertTrue(cv.isEmpty());
    }
}
