package com.example.entity;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckIdValidator implements ConstraintValidator<CheckId, Long> {
   public void initialize(CheckId constraint) {
   }

   @Override
   public boolean isValid(Long value, ConstraintValidatorContext context) {
      return value != 0;
   }
}
