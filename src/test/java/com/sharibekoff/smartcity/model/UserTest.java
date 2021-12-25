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

public class UserTest {

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testValidUser() {
        User user = new User("muratbek", "muratbek@gmail.com", "muratbek12345");
        Set<ConstraintViolation<User>> cv = validator.validate(user);
        assertTrue(cv.isEmpty());
    }

    @Test
    public void invalidEmailUser() {
        User user = new User("muratbek", "what is email?", "muratbek12345");
        Set<ConstraintViolation<User>> cv = validator.validate(user);
        assertEquals(1, cv.size());
    }

}
