 package com.ntt.es.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ntt.es.model.dto.SolicitudFinanciacionDto;
import com.ntt.es.validation.annotations.ValidarCodigoPostal;

public class CodigoPostalValidator implements ConstraintValidator<ValidarCodigoPostal, SolicitudFinanciacionDto> {

	private static Logger log = LoggerFactory.getLogger(CodigoPostalValidator.class);
	
    @Override
    public void initialize(ValidarCodigoPostal constraintAnnotation) {
    }

    @Override
    public boolean isValid(SolicitudFinanciacionDto dto, ConstraintValidatorContext context) {
      
    	log.debug("validando el codigo postal del pais destino de la inversion");

        if ("España".equals(dto.getPaisDestinoInversion())) {
            // Si el país es España, el código postal debe ser obligatorio y válido
            if (dto.getCodigoPostalInversion().equals("NA")) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("El código postal es obligatorio para España.")
                        .addPropertyNode("codigoPostalInversion")
                        .addConstraintViolation();
                return false;
            }

            // Validar que sea un código postal existente (aquí deberías agregar tu lógica específica)
            if (!esCodigoPostalValido(dto.getCodigoPostalInversion())) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("El código postal no es válido.")
                        .addPropertyNode("codigoPostalInversion")
                        .addConstraintViolation();
                return false;
            }

            // Restricción adicional: 5 dígitos obligatorios
            if (dto.getCodigoPostalInversion().length() != 5) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("El código postal debe tener 5 dígitos.")
                        .addPropertyNode("codigoPostalInversion")
                        .addConstraintViolation();
                return false;
            }
        } else {
            // Si el país no es España, el código postal se establece por defecto como "NA"
            dto.setCodigoPostalInversion("NA");
        }

        return true;
    }

    private boolean esCodigoPostalValido(String codigoPostal) {
    	 // Implementa la lógica para determinar si el código postal es válido
        return codigoPostal.length() == 5;
    }
}
