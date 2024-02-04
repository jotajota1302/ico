package com.ntt.es.validation.validator;

import javax.validation.ConstraintValidator;

import org.springframework.stereotype.Component;

import com.ntt.es.model.DatosTitularesDto;
import com.ntt.es.validation.annotations.ValidarAutonomo;

@Component
public class AutonomoValidator extends PersonaValidator implements ConstraintValidator<ValidarAutonomo, DatosTitularesDto> {

	

}
