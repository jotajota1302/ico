package com.ntt.es.validation.validator;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ntt.es.config.Constantes;
import com.ntt.es.model.dto.SolicitudFinanciacionDto;
import com.ntt.es.validation.annotations.ValidarCodigoCampoIntervencionAnexoVII;

public class CodigoCampoIntervencionAnexoVIIValidator
		implements ConstraintValidator<ValidarCodigoCampoIntervencionAnexoVII, SolicitudFinanciacionDto> {


	private static Logger log = LoggerFactory.getLogger(CodigoCampoIntervencionAnexoVIIValidator.class);

	@Override
	public void initialize(ValidarCodigoCampoIntervencionAnexoVII constraintAnnotation) {
	}

	@Override
	public boolean isValid(SolicitudFinanciacionDto dto, ConstraintValidatorContext context) {

		log.debug("validando el codigo campo intervencion del Anexo VII");
		
		boolean isValid=true;

		// Lista de líneas que deshabilitan el campo
		List<String> lineasDeshabilitadas = Arrays.asList(Constantes.LINEA_ICO_MRR_VERDE, Constantes.LINEA_ICO_MRR_VERDE_PERTE_ERHA,
				Constantes.LINEA_ICO_MRR_PROMOCION_DE_VIVIENDA_SOCIAL,Constantes.LINEA_ICO_MRR_EMPRESAS_Y_EMPRENDEDORES,
				Constantes.LINEA_ICO_MRR_EMPRESAS_Y_EMPRENDEDORES_SECTOR_TURISTICO);

		// Si la línea está deshabilitada, el campo debe ser nulo
		if (lineasDeshabilitadas.contains(dto.getLinea())) {
			dto.setCodigoCampoIntervencionAnexoVII(null);			
		}
		// Si la línea es ICO MRR Empresas y Emprendedores – PERTE NEL
		if (Constantes.LINEA_ICO_MRR_EMPRESAS_Y_EMPRENDEDORES_PERTE_NEL.equals(dto.getLinea())) {
			// Verifica que el código de intervención sea uno de los permitidos
			isValid=Constantes.COD_009BIS.equals(dto.getCodigoCampoIntervencionAnexoVII())
					|| Constantes.COD_011.equals(dto.getCodigoCampoIntervencionAnexoVII())&&isValid;
		}
		// Si la línea es ICO MRR Audiovisual o ICO MRR Audiovisual – PERTE NEL
		if (Constantes.LINEA_ICO_MRR_AUDIOVISUAL.equals(dto.getLinea()) || Constantes.LINEA_ICO_MRR_AUDIOVISUAL_PERTE_NEL.equals(dto.getLinea())) {
			// Verifica que el código de intervención sea uno de los permitidos
			isValid= Constantes.COD_010TER.equals(dto.getCodigoCampoIntervencionAnexoVII())
					|| Constantes.COD_021BIS.equals(dto.getCodigoCampoIntervencionAnexoVII())&&isValid;
		}

		return isValid;
	}

}
