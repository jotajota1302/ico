package com.ntt.es.validation.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.ntt.es.validation.validator.IntervencionAnexoVIValidator;

@Documented
@Constraint(validatedBy = IntervencionAnexoVIValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidarIntervencionAnexoVI {

    String message() default "La IntervencionAnexoVI no es válida.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
