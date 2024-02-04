package com.ntt.es.validation.validator;

import javax.validation.ConstraintValidatorContext;

import com.ntt.es.model.dto.DatosTitularesDto;
import com.ntt.es.validation.utils.ValidationUtils;

public class PersonaValidator {

	private static final String STRING_REGEX = "[a-zA-Z0-9.,;ñáéíóúüÑÁÉÍÓÚÜàèìòùÀÈÌÒÙ]+";

	public boolean isValid(DatosTitularesDto dto, ConstraintValidatorContext context) {
	
		boolean isValid = true;
	
		// Validación del DNI/NIE titular
		isValid=ValidationUtils.isValidNifFormat(dto.getDniNieTitular(), "El campo DNI/NIE titular no es correcto.", "dniNieTitular", context);		
	
		// Validación de Nombre Titular
		isValid=ValidationUtils.isValidStringRegex(dto.getNombreTitular(), "El campo Nombre Titular no es correcto.", "nombreTitular", context, STRING_REGEX);
			
		// Validación de Primer Apellido
		isValid=ValidationUtils.isValidStringRegex(dto.getPrimerApellidoTitular(), "El campo Primer Apellido no es correcto.", "primerApellidoTitular", context, STRING_REGEX);
			
		// Validación de Segundo Apellido
		isValid=ValidationUtils.isValidStringRegex(dto.getSegundoApellidoTitular(), "El campo Segundo Apellido no es correcto.", "segundoApellidoTitular", context, STRING_REGEX);
			
		// Validación de Fecha de Nacimiento
		isValid=ValidationUtils.isNotNull(dto.getFechaNacimiento(), "La fecha de nacimiento no puede ser nula.", "fechaNacimiento", context);		
	
		return isValid;
	}
	

}