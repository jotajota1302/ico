package com.ntt.es.validation.validator;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ntt.es.model.SolicitudFinanciacionDTO;
import com.ntt.es.validation.annotations.ValidarImporteInversionCirculante;

public class ImporteInversionCirculanteValidator
		implements ConstraintValidator<ValidarImporteInversionCirculante, SolicitudFinanciacionDTO> {

	private static Logger log = LoggerFactory.getLogger(ImporteInversionCirculanteValidator.class);
	
	@Override
	public void initialize(ValidarImporteInversionCirculante constraintAnnotation) {
	}

	@Override
	public boolean isValid(SolicitudFinanciacionDTO dto, ConstraintValidatorContext context) {

		log.info("validando el Importe de Inversion Circulante");
		
		List<String> lineasObligatorias = Arrays.asList("Línea ICO MRR Empresa y Emprendedores",
				"Línea ICO MRR Empresas y Emprendedores – Sector Turístico");

		// es obligatorio para estas lineas
		if (lineasObligatorias.contains(dto.getLinea())) {
			if (dto.getImporteInversionCirculante() <= 0) {
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate(
						"El importe de inversión en circulante es obligatorio para esta operación.")
						.addPropertyNode("importeInversionCirculante").addConstraintViolation();
				return false;
			}
		}

		List<String> lineasConValorCero = Arrays.asList("ICO MRR Verde", "ICO MRR Audiovisual",
				"ICO MRR Promoción de vivienda social", "ICO MRR Empresa y Emprendedores – PERTE NEL");

		// lineas donde el campo tiene que ser 0
		boolean inhabilitarCampo = lineasConValorCero.contains(dto.getLinea()) || "Leasing".equals(dto.getModalidad());

		if (inhabilitarCampo) {
			// Inhabilitar el campo y establecer el valor predeterminado
			dto.setImporteInversionCirculante(0.0);
		} else {
			// Validar que el importe informado sea igual o superior a 0 e inferior al
			// importe de activos

			if (dto.getImporteInversionCirculante() < 0
					|| dto.getImporteInversionCirculante() > dto.getImporteInversionActivosFijos()) {
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate(
						"El importe informado debe ser igual o superior a 0 e inferior al importe informado en el campo “Importe de la inversión en activos”.")
						.addPropertyNode("importeInversionCirculante").addConstraintViolation();
				return false;
			}
		}

		return true;
	}

}
