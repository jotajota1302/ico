

package com.ntt.es.validation.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.ntt.es.validation.validator.FechaPagoPrimeraFacturaValidator;

@Documented
@Constraint(validatedBy = FechaPagoPrimeraFacturaValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidarFechaPagoPrimeraFactura {
    String message() default "Error en la validación de la fecha de pago de la primera factura.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
