package com.ntt.es.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ntt.es.model.dto.SolicitudFinanciacionDto;
import com.ntt.es.validation.annotations.ValidarCategoriaDigitalizacion;

public class CategoriaDigitalizacionValidator implements ConstraintValidator<ValidarCategoriaDigitalizacion, SolicitudFinanciacionDto> {

	private static Logger log = LoggerFactory.getLogger(CategoriaDigitalizacionValidator.class);
	
    @Override
    public void initialize(ValidarCategoriaDigitalizacion constraintAnnotation) {
    }

    @Override
    public boolean isValid(SolicitudFinanciacionDto dto, ConstraintValidatorContext context) {
  
    	log.debug("validando la categoria de digitalizacion");
    	
        // Lógica de validación para la categoría de digitalización
        if (Boolean.TRUE.equals(dto.getEmpresaDigital())) {
            // Si la empresa es digital, la categoría debe estar presente
            if (dto.getCategoriaDigitalizacion() == null || dto.getCategoriaDigitalizacion().trim().isEmpty()) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("La categoría de digitalización es obligatoria cuando la empresa es digital.")
                        .addPropertyNode("categoriaDigitalizacion")
                        .addConstraintViolation();
                return false;
            }
        } else {
            // Si la empresa no es digital, la categoría debe ser null o vacía
            if (dto.getCategoriaDigitalizacion() != null && !dto.getCategoriaDigitalizacion().trim().isEmpty()) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("La categoría de digitalización no aplica cuando la empresa no es digital.")
                        .addPropertyNode("categoriaDigitalizacion")
                        .addConstraintViolation();
                return false;
            }
        }

        return true;
    }
    
 
}

