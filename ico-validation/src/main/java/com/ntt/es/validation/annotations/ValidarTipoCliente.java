package com.ntt.es.validation.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.ntt.es.validation.validator.TipoClienteValidator;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TipoClienteValidator.class)
public @interface ValidarTipoCliente {
	
	String message() default "El campo de tipo cliente es incorrecto";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
