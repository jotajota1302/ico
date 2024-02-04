package com.ntt.es.validation.validator;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ntt.es.config.Constantes;
import com.ntt.es.model.SolicitudFinanciacionDto;
import com.ntt.es.validation.annotations.ValidarImporteInversionCirculante;

public class ImporteInversionCirculanteValidator
		implements ConstraintValidator<ValidarImporteInversionCirculante, SolicitudFinanciacionDto> {


	private static Logger log = LoggerFactory.getLogger(ImporteInversionCirculanteValidator.class);
	
	@Override
	public void initialize(ValidarImporteInversionCirculante constraintAnnotation) {
	}

	@Override
	public boolean isValid(SolicitudFinanciacionDto dto, ConstraintValidatorContext context) {

		log.debug("validando el Importe de Inversion Circulante");
		
		List<String> lineasObligatorias = Arrays.asList(Constantes.LINEA_ICO_MRR_EMPRESAS_Y_EMPRENDEDORES,
				Constantes.LINEA_ICO_MRR_EMPRESAS_Y_EMPRENDEDORES_SECTOR_TURISTICO);

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

		List<String> lineasConValorCero = Arrays.asList(Constantes.LINEA_ICO_MRR_VERDE,Constantes.LINEA_ICO_MRR_AUDIOVISUAL,
				Constantes.LINEA_ICO_MRR_PROMOCION_DE_VIVIENDA_SOCIAL,Constantes.LINEA_ICO_MRR_EMPRESAS_Y_EMPRENDEDORES_PERTE_NEL);

		// lineas donde el campo tiene que ser 0
		boolean inhabilitarCampo = lineasConValorCero.contains(dto.getLinea()) || Constantes.LEASING.equals(dto.getModalidad());

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
