package com.thafonsotest.users_api.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;


import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CpfConstrainValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CpfValid {

    String message() default "CPF invalid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {}; // pass metadata

}
