package com.ntt.es.validation.validator;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ntt.es.model.SolicitudFinanciacionDto;
import com.ntt.es.validation.annotations.ValidarPaisDestinoInversion;

public class PaisDestinoInversionValidator implements ConstraintValidator<ValidarPaisDestinoInversion, SolicitudFinanciacionDto> {

	private static Logger log = LoggerFactory.getLogger(PaisDestinoInversionValidator.class);
	
    @Override
    public void initialize(ValidarPaisDestinoInversion constraintAnnotation) {
    }

    @Override
    public boolean isValid(SolicitudFinanciacionDto dto, ConstraintValidatorContext context) {
    	
    	log.debug("validando el pais destino Inversion");

        // Validar si el país es diferente a España
        if (!"España".equals(dto.getPaisDestinoInversion())) {
          
        	// Validar que no se informen países excluidos
            if (esPaisExcluido(dto.getPaisDestinoInversion())) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("No se permite el país ingresado.")
                        .addPropertyNode("paisDestinoInversion")
                        .addConstraintViolation();
                return false;
            }

            // Validar existencia de "interés español"
            if (dto.getInteresEspanol() == null || dto.getInteresEspanol().trim().isEmpty()) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("Se debe justificar el interés español.")
                        .addPropertyNode("interesEspanol")
                        .addConstraintViolation();
                return false;
            }

            // Validar existencia de "Justificación interés español"
            if (dto.getJustificacionInteresEspanol() == null || dto.getJustificacionInteresEspanol().trim().isEmpty()) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("Se debe justificar la existencia de interés español.")
                        .addPropertyNode("justificacionInteresEspanol")
                        .addConstraintViolation();
                return false;
            }

            // Validar que en el campo "Línea" no se hayan indicado valores específicos
            if (esOperacionExcluida(dto.getLinea())) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("La línea seleccionada no es permitida para este país.")
                        .addPropertyNode("linea")
                        .addConstraintViolation();
                return false;
            }
        }

        return true;
    }

    // Método auxiliar para verificar si el país está excluido
    private boolean esPaisExcluido(String pais) {
        // TO DO Lista de países excluidos (esto esta en un excel)
        List<String> paisesExcluidos = Arrays.asList("Egipto");
        return paisesExcluidos.contains(pais);
    }

    // Método auxiliar para verificar si la operación está excluida
    private boolean esOperacionExcluida(String linea) {
        // Lista de líneas excluidas 
        List<String> lineasExcluidas = Arrays.asList("ICO MRR Promoción de vivienda social", "ICO MRR Empresas y Emprendedores – PERTE NEL");
        return lineasExcluidas.contains(linea);
    }
}