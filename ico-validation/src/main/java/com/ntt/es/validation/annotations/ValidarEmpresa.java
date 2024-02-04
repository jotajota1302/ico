package com.ntt.es.validation.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.ntt.es.validation.validator.EmpresaPrivadaValidator;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmpresaPrivadaValidator.class)
public @interface ValidarEmpresa {
	
	String message() default "Los campos para la tipologia de Empresa Privada no son correctos";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
