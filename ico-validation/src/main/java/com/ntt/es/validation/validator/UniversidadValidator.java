package com.ntt.es.validation.validator;

import javax.validation.ConstraintValidator;

import org.springframework.stereotype.Component;

import com.ntt.es.model.dto.DatosTitularesDto;
import com.ntt.es.validation.annotations.ValidarEmpresa;

@Component
public class UniversidadValidator extends EmpresaValidator implements ConstraintValidator<ValidarEmpresa, DatosTitularesDto> {

	

}
