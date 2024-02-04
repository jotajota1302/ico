package com.ntt.es.validation.validator;

import java.util.Objects;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import com.ntt.es.model.DatosTitularesDto;
import com.ntt.es.validation.annotations.ValidarAutonomo;

@Component
public class AutonomoValidator implements ConstraintValidator<ValidarAutonomo, DatosTitularesDto> {

	public boolean isValid(DatosTitularesDto dto, ConstraintValidatorContext context) {

		boolean isValid = true;

		// Validación del DNI/NIE titular
		if (dto.getDniNieTitular().isEmpty()
				|| !dto.getDniNieTitular().isEmpty() && !dto.getDniNieTitular().matches("[a-zA-Z0-9]+")) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("El campo DNI/NIE titular no es correcto.")
					.addPropertyNode("dniNieTitular").addConstraintViolation();
			isValid = false;
		}		

		// Validación de Nombre Titular
		if (!validarCampoTexto(dto.getNombreTitular())) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("El campo Nombre Titular no es correcto.")
					.addPropertyNode("nombreTitular").addConstraintViolation();
			isValid = false;
		}

		// Validación de Primer Apellido
		if (!validarCampoTexto(dto.getPrimerApellidoTitular())) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("El campo Primer Apellido no es correcto.")
					.addPropertyNode("primerApellidoTitular").addConstraintViolation();
			isValid = false;
		}

		// Validación de Segundo Apellido
		if (!validarCampoTexto(dto.getSegundoApellidoTitular())) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("El campo Segundo Apellido no es correcto.")
					.addPropertyNode("segundoApellidoTitular").addConstraintViolation();
			isValid = false;
		}

		// Validación de Fecha de Nacimiento
		if (Objects.isNull(dto.getFechaNacimiento())) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("La fecha de nacimiento no puede ser nula.")
					.addPropertyNode("fechaNacimientoTitular").addConstraintViolation();
			isValid = false;
		}

		return isValid;
	}

	private boolean validarCampoTexto(String campoTexto) {
		String patron = "[a-zA-Z0-9.,;ñáéíóúüÑÁÉÍÓÚÜàèìòùÀÈÌÒÙ]+";
		return campoTexto.matches(patron);
	}

}
