package com.ntt.es.validation.validator;

import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ntt.es.model.dto.DatosTitularesDto;
import com.ntt.es.validation.utils.ValidationUtils;

public class EmpresaValidator {

	private static final String REGEX_STRING_VALID_CONTENT = "[a-zA-Z0-9.,;ñáéíóúüÑÁÉÍÓÚÜàèìòùÀÈÌÒÙ]+";

	Logger log = LoggerFactory.getLogger(EmpresaValidator.class);

	public boolean isValid(DatosTitularesDto dto, ConstraintValidatorContext context) {

		log.debug("validando los campos de Empresa");

		boolean isValid = true;

		// Validación del NIF titular
		isValid = ValidationUtils.isValidNifFormat(dto.getNifTitular(), "El campo NIF del titular no es correcto.",
				"nifTitular", context);

		// Validación de la Razón Social titular
		isValid = ValidationUtils.isValidStringRegex(dto.getRazonSocialTitular(),
				"El campo Razón Social titular no es correcto.", "razonSocialTitular", context,
				REGEX_STRING_VALID_CONTENT);

		// Validación del Poder Adjudicador
		if (dto.getEsPoderAdjudicador() == null) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(
					"El campo '¿Es la empresa un poder adjudicador?' no puede ser nulo.")
					.addPropertyNode("esPoderAdjudicador").addConstraintViolation();
			isValid = false;
		}

		// solo se validan si es poder adjudicador
		if (dto.getEsPoderAdjudicador() != null && dto.getEsPoderAdjudicador()) {
			// Validación del Nif del contratista titular
			isValid = ValidationUtils.isValidNifFormat(dto.getNifContratistaTitular(),
					"El campo NIF Contratista titular no es correcto.", "nifContratistaTitular", context);

			// Validación del Nif del subcontratista
			isValid = ValidationUtils.isValidNifFormat(dto.getNifSubcontratistaTitular(),
					"El cammpo NIF Subcontratista titular no es correcto.", "nifSubcontratistaTitular", context);

		}
		// Validación del DNI/NIE titular real
		isValid = ValidationUtils.isValidNifFormat(dto.getDniNieTitularReal(),
				"El campo DNI/NIE titular real no es correcto.", "dniNieTitularReal", context);
		// Validación del Primer Apellio titualr real
		isValid = ValidationUtils.isValidStringRegex(dto.getPrimerApellidoTitularReal(),
				"El campo Primer apellido titular real no es correcto.", "primerApellidoTitularReal", context,
				REGEX_STRING_VALID_CONTENT);

		return isValid;
	}

}