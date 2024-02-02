package com.ntt.es.validation.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.ntt.es.validation.validator.ModalidadValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ModalidadValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidarModalidad {

    String message() default "La modalidad no es válida para la línea seleccionada.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
