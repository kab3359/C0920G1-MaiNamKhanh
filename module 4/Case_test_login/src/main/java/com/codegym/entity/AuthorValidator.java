package com.codegym.entity;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AuthorValidator implements ConstraintValidator<Author, Integer> {
   @Override
   public void initialize(Author constraint) {

   }

   @Override
   public boolean isValid(Integer obj, ConstraintValidatorContext context) {
      context.getDefaultConstraintMessageTemplate();
      return false;
   }

   public Date StringToDate(String str){
      Date date = null;
      try {
         date = new SimpleDateFormat("dd/MM/yyyy").parse(str);
      } catch (ParseException e) {
         e.printStackTrace();
      }
      return date;
   }
}
