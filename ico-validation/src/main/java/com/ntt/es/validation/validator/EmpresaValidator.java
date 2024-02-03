package com.ntt.es.validation.validator;

import javax.validation.ConstraintValidatorContext;

import com.ntt.es.model.DatosTitularesDto;

public class EmpresaValidator {

	public boolean isValid(DatosTitularesDto dto, ConstraintValidatorContext context) {
			
			boolean isValid=true;
		
			// Validación del NIF titular
		    if (dto.getNifTitular()== null || !dto.getNifTitular().matches("[a-zA-Z0-9]+")) {
		        context.disableDefaultConstraintViolation();
		        context.buildConstraintViolationWithTemplate("El campo NIF del titular no es correcto.")
		                .addPropertyNode("nifTitular")
		                .addConstraintViolation();
		        isValid=false;
		    }	
		    
		    // Validación de la Razón Social titular
		    if (dto.getRazonSocialTitular() == null || dto.getRazonSocialTitular().isEmpty() ||!dto.getRazonSocialTitular().matches("[a-zA-Z0-9.,;ñáéíóúüÑÁÉÍÓÚÜàèìòùÀÈÌÒÙ]+")) {
		        context.disableDefaultConstraintViolation();
		        context.buildConstraintViolationWithTemplate("El campo Razón Social titular no es correcto.")
		                .addPropertyNode("razonSocialTitular")
		                .addConstraintViolation();
		        isValid=false;
		    }	
		    
		    // Validación del Poder Adjudicador
		    if (dto.getEsPoderAdjudicador() == null) {
		        context.disableDefaultConstraintViolation();
		        context.buildConstraintViolationWithTemplate("El campo '¿Es la empresa un poder adjudicador?' no puede ser nulo.")
		                .addPropertyNode("esPoderAdjudicador")
		                .addConstraintViolation();
		        isValid = false;
		    }
		    
		    //solo se validan si es poder adjudicador
		    if(dto.getEsPoderAdjudicador()) {
			    // Validación del Nif del contratista titular
			    if (dto.getNifContratistaTitular().isEmpty()||!dto.getNifContratistaTitular().isEmpty()&& !dto.getNifContratistaTitular().matches("[a-zA-Z0-9]+")) {
			        context.disableDefaultConstraintViolation();
			        context.buildConstraintViolationWithTemplate("El campo NIF Contratista titular no es correcto.")
			                .addPropertyNode("nifContratistaTitular")
			                .addConstraintViolation();
			        isValid = false;
			    }
			    // Validación del Nif del subcontratista
			    if (dto.getNifSubcontratistaTitular().isEmpty()||!dto.getNifSubcontratistaTitular().isEmpty() && !dto.getNifSubcontratistaTitular().matches("[a-zA-Z0-9]+")) {
			        context.disableDefaultConstraintViolation();
			        context.buildConstraintViolationWithTemplate("El cammpo NIF Subcontratista titular no es correcto.")
			                .addPropertyNode("nifSubcontratistaTitular")
			                .addConstraintViolation();
			        isValid = false;
			    }
		    }
		    
		    if (dto.getDniNieTitularReal().isEmpty()||!dto.getDniNieTitularReal().isEmpty()&& !dto.getDniNieTitularReal().matches("[a-zA-Z0-9]+")) {
		        context.disableDefaultConstraintViolation();
		        context.buildConstraintViolationWithTemplate("El campo DNI/NIE titular real no es correcto.")
		                .addPropertyNode("dniNieTitularReal")
		                .addConstraintViolation();
		        isValid = false;
		    }
		    if (dto.getPrimerApellidoTitularReal().isEmpty()||!dto.getPrimerApellidoTitularReal().isEmpty() && !dto.getPrimerApellidoTitularReal().matches("[a-zA-Z0-9.,;ñáéíóúüÑÁÉÍÓÚÜàèìòùÀÈÌÒÙ]+")) {
		        context.disableDefaultConstraintViolation();
		        context.buildConstraintViolationWithTemplate("El campo Primer apellido titular real no es correcto.")
		                .addPropertyNode("primerApellidoTitularReal")
		                .addConstraintViolation();
		        isValid = false;
		    }
		
		return isValid;
	}

}