package com.ntt.es.validation.validator;

import java.time.LocalDate;
import java.time.ZoneId;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ntt.es.model.SolicitudFinanciacionDTO;
import com.ntt.es.validation.annotations.ValidarFechaPagoPrimeraFactura;

public class FechaPagoPrimeraFacturaValidator implements ConstraintValidator<ValidarFechaPagoPrimeraFactura,SolicitudFinanciacionDTO> {

	private static Logger log = LoggerFactory.getLogger(FechaPagoPrimeraFacturaValidator.class);
	
    @Override
    public void initialize(ValidarFechaPagoPrimeraFactura constraintAnnotation) {
    }

    @Override
    public boolean isValid(SolicitudFinanciacionDTO dto, ConstraintValidatorContext context) {
       
    	log.debug("validando la fecha de pago de la primera factura");
    	
        LocalDate fechaPagoPrimeraFacturaLocalDate = dto.getFechaPagoPrimeraFactura().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    	
        // Validar que la fecha no sea anterior al 01-01-2023, excepto para la línea ICO MRR Promoción Vivienda Social
        if (!"ICO MRR Promoción Vivienda Social".equals(dto.getLinea()) && fechaPagoPrimeraFacturaLocalDate.isBefore(LocalDate.of(2023, 1, 1))) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("La fecha de pago de la primera factura no puede ser anterior al 01-01-2023.")
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}
