package com.ntt.es.validation.validator;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ntt.es.model.SolicitudFinanciacionDTO;
import com.ntt.es.validation.annotations.ValidarIntervencionAnexoVI;

public class IntervencionAnexoVIValidator
		implements ConstraintValidator<ValidarIntervencionAnexoVI, SolicitudFinanciacionDTO> {

	private static Logger log = LoggerFactory.getLogger(IntervencionAnexoVIValidator.class);

	@Override
	public void initialize(ValidarIntervencionAnexoVI constraintAnnotation) {
	}

	@Override
	public boolean isValid(SolicitudFinanciacionDTO dto, ConstraintValidatorContext context) {
	    log.debug("Validando la intervención del AnexoVI");

	    String linea = dto.getLinea();
	    String categoria = dto.getCategoriaDigitalizacion();

	    List<String> lineasDeshabilitadas = Arrays.asList(
	            "ICO MRR Empresas y Emprendedores",
	            "ICO MRR Empresas y Emprendedores – Sector Turístico",
	            "ICO MRR Empresas y Emprendedores – PERTE NEL",
	            "ICO MRR Audiovisual",
	            "ICO MRR Audiovisual – PERTE NEL"
	    );

	    if (lineasDeshabilitadas.contains(linea)) {
	        dto.setCodigoIntervencionAnexoVI(null);
	        return true;
	    }

	    if ("ICO MRR Promoción Vivienda Social".equals(linea)) {
	        return "025ter".equals(categoria) || "025bis".equals(categoria);
	    }

	    if ("ICO MRR Verde".equals(linea) || "ICO MRR Verde – PERTE ERHA".equals(linea)) {
	        boolean categoriaValida = "CategoriaValida1".equals(categoria) || "CategoriaValida2".equals(categoria);

	        if ("ICO MRR Verde – PERTE ERHA".equals(linea)) {
	            return categoriaValida && ("022".equals(categoria) || "033".equals(categoria) || "027".equals(categoria));
	        }

	        return categoriaValida;
	    }

	    return true;
	}

}
