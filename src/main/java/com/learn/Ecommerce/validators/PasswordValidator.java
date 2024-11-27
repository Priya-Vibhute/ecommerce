package com.learn.Ecommerce.validators;

import com.learn.Ecommerce.Dto.UserDto;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PasswordMatch, UserDto>{

	@Override
	public boolean isValid(UserDto value, ConstraintValidatorContext context) {
		//"Hello".equals("Hello")
		// TODO Auto-generated method stub
		return value.getPassword().equals(value.getConfirmPassword());
	}
	
	

}
