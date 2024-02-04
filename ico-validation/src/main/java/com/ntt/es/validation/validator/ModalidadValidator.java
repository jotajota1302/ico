package com.ntt.es.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ntt.es.config.Constantes;
import com.ntt.es.model.SolicitudFinanciacionDto;
import com.ntt.es.validation.annotations.ValidarModalidad;

public class ModalidadValidator implements ConstraintValidator<ValidarModalidad, SolicitudFinanciacionDto> {

	private static Logger log = LoggerFactory.getLogger(ModalidadValidator.class);

	@Override
	public void initialize(ValidarModalidad constraintAnnotation) {
	}

	@Override
	public boolean isValid(SolicitudFinanciacionDto dto, ConstraintValidatorContext context) {

		log.debug("validando la modalidad");

		if (Constantes.LINEA_ICO_MRR_AUDIOVISUAL.equals(dto.getLinea())
				&& !Constantes.PRESTAMO.equals(dto.getModalidad())) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(
					"La modalidad debe ser 'Préstamo' para la línea 'ICO MRR Promoción vivienda social'.")
					.addPropertyNode("modalidad").addConstraintViolation();
			return false;
		}

		return true;
	}

}
