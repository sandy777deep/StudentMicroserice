package com.microservices.project.customAnnotation;


import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class validation implements ConstraintValidator<myValidation, Integer> {

	@Override
	public boolean isValid(Integer arg0, ConstraintValidatorContext arg1) {
		List<Integer> Lobj=Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12);
		return  Lobj.contains(arg0);
	}
	
	

}
