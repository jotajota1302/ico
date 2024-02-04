package com.ntt.es.validation.validator;

import java.time.LocalDate;
import java.time.ZoneId;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ntt.es.config.Constantes;
import com.ntt.es.model.SolicitudFinanciacionDto;
import com.ntt.es.validation.annotations.ValidarFechaPagoPrimeraFactura;

public class FechaPagoPrimeraFacturaValidator
		implements ConstraintValidator<ValidarFechaPagoPrimeraFactura, SolicitudFinanciacionDto> {

	private static Logger log = LoggerFactory.getLogger(FechaPagoPrimeraFacturaValidator.class);

	@Override
	public void initialize(ValidarFechaPagoPrimeraFactura constraintAnnotation) {
	}

	@Override
	public boolean isValid(SolicitudFinanciacionDto dto, ConstraintValidatorContext context) {

		log.debug("Validando la fecha de pago de la primera factura");

		LocalDate fechaPagoPrimeraFacturaLocalDate = dto.getFechaPagoPrimeraFactura().toInstant()
				.atZone(ZoneId.systemDefault()).toLocalDate();

		// Validar que la fecha no sea anterior al 01-01-2023, excepto para la línea ICO
		// MRR Promoción Vivienda Social
		if (!Constantes.LINEA_ICO_MRR_PROMOCION_DE_VIVIENDA_SOCIAL.equals(dto.getLinea())
				&& fechaPagoPrimeraFacturaLocalDate.isBefore(LocalDate.of(2023, 1, 1))) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(
					"La fecha de pago de la primera factura no puede ser anterior al 01-01-2023.")
					.addConstraintViolation();
			return false;
		}

		// Validar que la fecha no sea anterior al 01-01-2023 para otras líneas
		if (fechaPagoPrimeraFacturaLocalDate.isBefore(LocalDate.of(2023, 1, 1))) {
			return false;
		}

		return true;
		
	}
}
