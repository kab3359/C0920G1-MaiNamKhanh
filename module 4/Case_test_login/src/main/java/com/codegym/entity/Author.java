package com.codegym.entity;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = AuthorValidator.class)
@Documented
public @interface Author {
    String message() default "Sai định dạng";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
