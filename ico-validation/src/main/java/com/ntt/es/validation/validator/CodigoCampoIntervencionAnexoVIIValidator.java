package com.ntt.es.validation.validator;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ntt.es.model.SolicitudFinanciacionDTO;
import com.ntt.es.validation.annotations.ValidarCodigoCampoIntervencionAnexoVII;

public class CodigoCampoIntervencionAnexoVIIValidator
		implements ConstraintValidator<ValidarCodigoCampoIntervencionAnexoVII, SolicitudFinanciacionDTO> {

	private static Logger log = LoggerFactory.getLogger(CodigoCampoIntervencionAnexoVIIValidator.class);

	@Override
	public void initialize(ValidarCodigoCampoIntervencionAnexoVII constraintAnnotation) {
	}

	@Override
	public boolean isValid(SolicitudFinanciacionDTO dto, ConstraintValidatorContext context) {

		log.debug("validando el codigo campo intervencion del Anexo VII");

		// Lista de líneas que deshabilitan el campo
		List<String> lineasDeshabilitadas = Arrays.asList("ICO MRR Verde", "ICO MRR Verde – PERTE ERHA",
				"ICO MRR Promoción de vivienda social", "ICO MRR Empresas y Emprendedores",
				"ICO MRR Empresas y Emprendedores – Sector Turístico");

		// Si la línea está deshabilitada, el campo debe ser nulo
		if (lineasDeshabilitadas.contains(dto.getLinea())) {
			dto.setCodigoCampoIntervencionAnexoVII(null);
			return true;
		}

		// Si la línea es ICO MRR Empresas y Emprendedores – PERTE NEL
		if ("ICO MRR Empresas y Emprendedores – PERTE NEL".equals(dto.getLinea())) {
			// Verifica que el código de intervención sea uno de los permitidos
			return "009bis".equals(dto.getCodigoCampoIntervencionAnexoVII())
					|| "011".equals(dto.getCodigoCampoIntervencionAnexoVII());
		}

		// Si la línea es ICO MRR Audiovisual o ICO MRR Audiovisual – PERTE NEL
		if ("ICO MRR Audiovisual".equals(dto.getLinea()) || "ICO MRR Audiovisual – PERTE NEL".equals(dto.getLinea())) {
			// Verifica que el código de intervención sea uno de los permitidos
			return "010ter".equals(dto.getCodigoCampoIntervencionAnexoVII())
					|| "021bis".equals(dto.getCodigoCampoIntervencionAnexoVII());
		}

		// Si la línea no coincide con ninguna condición anterior, la validación pasa
		// automáticamente
		return true;
	}

}
