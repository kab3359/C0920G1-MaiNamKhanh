package com.codegym.entity;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AuthorValidator implements ConstraintValidator<Author, String> {
   public void initialize(Author constraint) {
   }

   public boolean isValid(String obj, ConstraintValidatorContext context) {
      return false;
   }
}
