package com.ntt.es.validation.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.ntt.es.validation.validator.CategoriaDigitalizacionValidator;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CategoriaDigitalizacionValidator.class)
public @interface ValidarCategoriaDigitalizacion {
    String message() default "Error de validación de categoría de digitalización";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
