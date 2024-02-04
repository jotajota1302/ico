package com.ntt.es.validation.validator;

import javax.validation.ConstraintValidator;

import org.springframework.stereotype.Component;

import com.ntt.es.model.dto.DatosTitularesDto;
import com.ntt.es.validation.annotations.ValidarHogar;

@Component
public class HogarValidator extends PersonaValidator implements ConstraintValidator<ValidarHogar, DatosTitularesDto> {

}
