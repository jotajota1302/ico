package com.ntt.es.validation.validator;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ntt.es.config.Constantes;
import com.ntt.es.model.dto.SolicitudFinanciacionDto;
import com.ntt.es.validation.annotations.ValidarPaisDestinoInversion;
import com.ntt.es.validation.utils.ValidationUtils;

public class PaisDestinoInversionValidator
		implements ConstraintValidator<ValidarPaisDestinoInversion, SolicitudFinanciacionDto> {

	private static Logger log = LoggerFactory.getLogger(PaisDestinoInversionValidator.class);

	@Override
	public void initialize(ValidarPaisDestinoInversion constraintAnnotation) {
	}

	@Override
	public boolean isValid(SolicitudFinanciacionDto dto, ConstraintValidatorContext context) {

		log.debug("validando el pais destino Inversion");

		boolean isValid = true;

		// Validar si el país es diferente a España
		if (!Constantes.ESPANA.equals(dto.getPaisDestinoInversion())) {

			// Validar que no se informen países excluidos
			if (esPaisExcluido(dto.getPaisDestinoInversion())) {
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate("No se permite el país ingresado.")
						.addPropertyNode("paisDestinoInversion").addConstraintViolation();
				isValid = false;
			}

			// Validar existencia de interés español
			isValid = ValidationUtils.isValidString(dto.getInteresEspanol(), "El campo interes español no es correcto.",
					"interesEspanol", context);

			// Validar existencia de Justificación interés español
			isValid = ValidationUtils.isValidString(dto.getJustificacionInteresEspanol(),
					"El campo justificacion de interes español no es correcto.", "justificacionInteresEspanol",
					context);

			// Validar que en el campo Línea no se hayan indicado valores específicos
			if (esOperacionExcluida(dto.getLinea())) {
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate("La línea seleccionada no es permitida para este país.")
						.addPropertyNode("linea").addConstraintViolation();
				return false;
			}
		}

		return isValid;
	}

	private boolean esPaisExcluido(String pais) {
		// TODO Lista de países excluidos (esto esta en un excel)
		List<String> paisesExcluidos = Arrays.asList("Egipto");
		return paisesExcluidos.contains(pais);
	}

	private boolean esOperacionExcluida(String linea) {
		List<String> lineasExcluidas = Arrays.asList(Constantes.LINEA_ICO_MRR_PROMOCION_DE_VIVIENDA_SOCIAL,
				Constantes.LINEA_ICO_MRR_EMPRESAS_Y_EMPRENDEDORES_PERTE_NEL);
		return lineasExcluidas.contains(linea);
	}
}