package com.thafonsotest.users_api.validations;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CpfConstrainValidator implements ConstraintValidator<CpfValid, String> {
    @Override
    public boolean isValid(String Cpf, ConstraintValidatorContext context){
        return CpfValidator.isValid(Cpf);
    }
}
