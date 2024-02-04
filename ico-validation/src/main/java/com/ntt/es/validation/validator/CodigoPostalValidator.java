package com.ntt.es.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ntt.es.config.Constantes;
import com.ntt.es.model.dto.SolicitudFinanciacionDto;
import com.ntt.es.validation.annotations.ValidarCodigoPostal;
import com.ntt.es.validation.utils.ValidationUtils;

public class CodigoPostalValidator implements ConstraintValidator<ValidarCodigoPostal, SolicitudFinanciacionDto> {

	private static Logger log = LoggerFactory.getLogger(CodigoPostalValidator.class);

	@Override
	public void initialize(ValidarCodigoPostal constraintAnnotation) {
	}

	@Override
	public boolean isValid(SolicitudFinanciacionDto dto, ConstraintValidatorContext context) {

		log.debug("validando el codigo postal del pais destino de la inversion");

		boolean isValid = true;

		if (Constantes.ESPANA.equals(dto.getPaisDestinoInversion())) {
			// Si el país es España, el código postal debe ser obligatorio y válido
			isValid = ValidationUtils.isNotNullOrEmpty(dto.getCodigoPostalInversion(),
					"El código postal no puede estar vacio.", "codigoPostalInversion", context)&&isValid;

			isValid = ValidationUtils.isValidLength(dto.getCodigoPostalInversion(), 5,
					"El código postal debe tener una longitud de 5 caracteres.", "codigoPostalInversion", context)&&isValid;

			isValid = ValidationUtils.isValidDigits(dto.getCodigoPostalInversion(),
					"El código postal solo puede contenter numeros.", "codigoPostalInversion", context)&&isValid;
		} else {
			// Si el país no es España, el código postal se establece por defecto como "NA"
			dto.setCodigoPostalInversion("NA");
		}
		return isValid;
	}

}
