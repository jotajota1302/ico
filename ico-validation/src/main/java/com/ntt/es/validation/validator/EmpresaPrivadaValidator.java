package com.ntt.es.validation.validator;

import javax.validation.ConstraintValidator;

import org.springframework.stereotype.Component;

import com.ntt.es.model.DatosTitularesDto;
import com.ntt.es.validation.annotations.ValidarEmpresaPrivada;

@Component
public class EmpresaPrivadaValidator extends EmpresaValidator implements ConstraintValidator<ValidarEmpresaPrivada, DatosTitularesDto> {

	

}
