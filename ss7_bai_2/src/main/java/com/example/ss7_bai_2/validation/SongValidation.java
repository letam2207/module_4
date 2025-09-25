package com.example.ss7_bai_2.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class SongValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
