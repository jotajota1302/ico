package com.ntt.es.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ntt.es.model.dto.SolicitudFinanciacionDto;
import com.ntt.es.validation.annotations.ValidarCategoriaDigitalizacion;
import com.ntt.es.validation.utils.ValidationUtils;

public class CategoriaDigitalizacionValidator implements ConstraintValidator<ValidarCategoriaDigitalizacion, SolicitudFinanciacionDto> {

	private static Logger log = LoggerFactory.getLogger(CategoriaDigitalizacionValidator.class);
	
    @Override
    public void initialize(ValidarCategoriaDigitalizacion constraintAnnotation) {
    }

    @Override
    public boolean isValid(SolicitudFinanciacionDto dto, ConstraintValidatorContext context) {
  
    	log.debug("validando la categoria de digitalizacion");
    	
    	Boolean isValid=true;
    	
        if (Boolean.TRUE.equals(dto.getEmpresaDigital())) {
            isValid=ValidationUtils.isValidString(dto.getCategoriaDigitalizacion(), "La categoría de digitalización es obligatoria cuando la empresa es digital.", "categoriaDigitalizacion", context);
        } else {           
        	isValid=!ValidationUtils.isValidString(dto.getCategoriaDigitalizacion(), "La categoría de digitalización no aplica cuando la empresa no es digital.", "categoriaDigitalizacion", context);
        }

        return isValid;
    }
    
 
}

