package com.ntt.es.validation.validator;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ntt.es.config.Constantes;
import com.ntt.es.model.dto.SolicitudFinanciacionDto;
import com.ntt.es.validation.annotations.ValidarIntervencionAnexoVI;

public class IntervencionAnexoVIValidator
		implements ConstraintValidator<ValidarIntervencionAnexoVI, SolicitudFinanciacionDto> {

	

	private static Logger log = LoggerFactory.getLogger(IntervencionAnexoVIValidator.class);

	@Override
	public void initialize(ValidarIntervencionAnexoVI constraintAnnotation) {
	}

	@Override
	public boolean isValid(SolicitudFinanciacionDto dto, ConstraintValidatorContext context) {

		log.debug("Validando la intervención del AnexoVI");

		boolean isValid = true;

		String linea = dto.getLinea();
	
		List<String> lineasDeshabilitadas = Arrays.asList(Constantes.LINEA_ICO_MRR_EMPRESAS_Y_EMPRENDEDORES,
				Constantes.LINEA_ICO_MRR_EMPRESAS_Y_EMPRENDEDORES_SECTOR_TURISTICO,
				Constantes.LINEA_ICO_MRR_EMPRESAS_Y_EMPRENDEDORES_PERTE_NEL, Constantes.LINEA_ICO_MRR_AUDIOVISUAL,
				Constantes.LINEA_ICO_MRR_AUDIOVISUAL_PERTE_NEL);

		if (lineasDeshabilitadas.contains(linea)) {
			dto.setCodigoIntervencionAnexoVI(null);
			isValid = true;
		}

		if (Constantes.LINEA_ICO_MRR_PROMOCION_DE_VIVIENDA_SOCIAL.equals(linea)) {

			List<String> valoresPermitidos = Arrays.asList(Constantes.COD_025TER, Constantes.COD_025BIS);

			if (!dto.getCodigoIntervencionAnexoVI().isEmpty()
					&& !valoresPermitidos.contains(dto.getCodigoIntervencionAnexoVI())) {
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate(
						"El valor del codigoIntervencionAnexoVI no es correcto para para esta linea")
						.addPropertyNode("codigoIntervencionAnexoVI").addConstraintViolation();
				isValid = false;
			}
		}

		if (Constantes.LINEA_ICO_MRR_VERDE.equals(linea) || Constantes.LINEA_ICO_MRR_VERDE_PERTE_ERHA.equals(linea)) {

			// TODO los posibles valores vienen de Ver Excel Códigos campos de intervención
			// Anexo VI en la carpeta material complementario formulario de solicitud.
			List<String> valoresPermitidosMrrVerde = Arrays.asList("A", "B", "C");

			if (!dto.getCodigoIntervencionAnexoVI().isEmpty()
					&& !valoresPermitidosMrrVerde.contains(dto.getCodigoIntervencionAnexoVI())) {
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate("El valor del codigoIntervencionAnexoVI no es correcto para esta linea")
						.addPropertyNode("codigoIntervencionAnexoVI").addConstraintViolation();
				isValid = false;
			}
		}

		if (Constantes.LINEA_ICO_MRR_VERDE_PERTE_ERHA.equals(linea)) {
			
			//TODO estos valores sacarlos de aqui
			List<String> valoresPermitidosMrrVerde = Arrays.asList("022", "033", "027");

			if (!dto.getCodigoIntervencionAnexoVI().isEmpty()
					&& !valoresPermitidosMrrVerde.contains(dto.getCodigoIntervencionAnexoVI())) {
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate("El valor del codigoIntervencionAnexoVI no es correcto para esta linea")
						.addPropertyNode("codigoIntervencionAnexoVI").addConstraintViolation();
				isValid = false;
			}
		}

		return isValid;
	}

}
