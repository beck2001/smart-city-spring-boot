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

public class RestaurantTest {

    private Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void validRestaurant() {
        Restaurant restaurant = new Restaurant(1L, "restaurant #1", "location #1", 10_000d);
        Set<ConstraintViolation<Restaurant>> cv = validator.validate(restaurant);
        assertTrue(cv.isEmpty());
    }

    @Test
    public void negativePriceTest() {
        Restaurant restaurant = new Restaurant(1L, "restaurant #1", "location #1", -10_000d);
        Set<ConstraintViolation<Restaurant>> cv = validator.validate(restaurant);
        assertEquals(1, cv.size());
    }
}
