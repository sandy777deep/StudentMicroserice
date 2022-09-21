package com.microservices.project.customAnnotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;




@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy=validation.class)
public  @interface myValidation {
	
	public String message() default "Invalid range of Standered : please enter in between 1 and 12";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

	
}
