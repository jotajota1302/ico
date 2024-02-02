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
public @interface ValidarCodigoCampoIntervencionAnexoVII {

    String message() default "El codigo del Campo de Intervencion del Anexo VII no es valido.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
